package com.example.aptech_final_project_be.service;

import com.example.aptech_final_project_be.dto.DangKyRequest;
import com.example.aptech_final_project_be.dto.DangNhapRequest;
import com.example.aptech_final_project_be.dto.DangNhapResponse;
import com.example.aptech_final_project_be.model.GiaoVien;
import com.example.aptech_final_project_be.model.NguoiDung;
import com.example.aptech_final_project_be.model.PhanQuyen;
import com.example.aptech_final_project_be.model.SinhVien;
import com.example.aptech_final_project_be.model.VaiTro;
import com.example.aptech_final_project_be.repository.NguoiDungRepository;
import com.example.aptech_final_project_be.repository.VaiTroRepository;
import com.example.aptech_final_project_be.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    
    @Autowired
    private VaiTroRepository vaiTroRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> dangKy(DangKyRequest request, String role) {
        try {
            // Kiểm tra tồn tại
            if (nguoiDungRepository.existsByTenDangNhap(request.getTenDangNhap())) {
                throw new RuntimeException("Tên đăng nhập đã tồn tại");
            }

            if (nguoiDungRepository.existsByEmail(request.getEmail())) {
                throw new RuntimeException("Email đã tồn tại");
            }

            // Map role từ API sang tên trong database
            String dbRole = mapRole(role);
            
            // Thêm vai trò
            VaiTro vaiTro = vaiTroRepository.findByTenVaiTro(dbRole)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy vai trò: " + dbRole));
            
            // Tạo người dùng mới
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setTenDangNhap(request.getTenDangNhap());
            nguoiDung.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
            nguoiDung.setEmail(request.getEmail());
            nguoiDung.setSoDienThoai(request.getSoDienThoai());
            
            // Tạo phân quyền
            PhanQuyen phanQuyen = new PhanQuyen();
            phanQuyen.setNguoiDung(nguoiDung);
            phanQuyen.setVaiTro(vaiTro);
            nguoiDung.getPhanQuyens().add(phanQuyen);

            // Lưu thông tin chi tiết theo role
            if (dbRole.equals("Sinh Viên")) {
                if (request.getTenSinhVien() == null || request.getLop() == null) {
                    throw new RuntimeException("Thiếu thông tin sinh viên");
                }
                SinhVien sinhVien = new SinhVien();
                sinhVien.setTenSinhVien(request.getTenSinhVien());
                sinhVien.setLop(request.getLop());
                sinhVien.setMaChuyenNganh(request.getMaChuyenNganh());
                sinhVien.setNamVaoHoc(request.getNamVaoHoc());
                sinhVien.setNguoiDung(nguoiDung);
                nguoiDung.setSinhVien(sinhVien);
            } else if (dbRole.equals("Giáo Viên")) {
                if (request.getTenGiaoVien() == null || request.getMaKhoa() == null) {
                    throw new RuntimeException("Thiếu thông tin giáo viên");
                }
                GiaoVien giaoVien = new GiaoVien();
                giaoVien.setTenGiaoVien(request.getTenGiaoVien());
                giaoVien.setMaKhoa(request.getMaKhoa());
                giaoVien.setEmail(request.getEmail());
                giaoVien.setSoDienThoai(request.getSoDienThoai());
                giaoVien.setNguoiDung(nguoiDung);
                nguoiDung.setGiaoVien(giaoVien);
            }

            nguoiDungRepository.save(nguoiDung);
            log.info("Đăng ký thành công cho user: {}", request.getTenDangNhap());
            
            return ResponseEntity.ok("Đăng ký thành công");
        } catch (Exception e) {
            log.error("Lỗi đăng ký: {}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    // Helper method để map role
    private String mapRole(String role) {
        switch (role.toUpperCase()) {
            case "SINH_VIEN":
                return "SINH_VIEN";
            case "GIAO_VIEN":
                return "GIAO_VIEN";
            case "ADMIN":
                return "ADMIN";
            case "KE_TOAN":
                return "KE_TOAN";
            case "HIEU_TRUONG":
                return "HIEU_TRUONG";
            case "GIAO_VU":
                return "GIAO_VU";
            case "PHU_HUYNH":
                return "PHU_HUYNH";
            case "KHACH":
                return "KHACH";
            default:
                throw new RuntimeException("Vai trò không hợp lệ");
        }
    }

    public ResponseEntity<?> dangNhap(DangNhapRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getTenDangNhap(), request.getMatKhau())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            NguoiDung nguoiDung = userDetails.getNguoiDung();
            
            String jwt = jwtService.generateToken(nguoiDung);

            List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

            return ResponseEntity.ok(new DangNhapResponse(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles
            ));
        } catch (Exception e) {
            log.error("Lỗi đăng nhập: ", e);
            throw new RuntimeException("Có lỗi xảy ra khi đăng nhập");
        }
    }
} 