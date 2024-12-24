package com.example.aptech_final_project_be.controller;

import com.example.aptech_final_project_be.dto.DangKyRequest;
import com.example.aptech_final_project_be.dto.DangNhapRequest;
import com.example.aptech_final_project_be.dto.DangNhapResponse;
import com.example.aptech_final_project_be.service.AuthService;
import com.example.aptech_final_project_be.repository.BlacklistedTokenRepository;
import com.example.aptech_final_project_be.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BlacklistedTokenRepository blacklistedTokenRepository;

    @Operation(
        summary = "Register student",
        description = "Register new student account"
    )
    @PostMapping(value = "/dang-ky/sinh-vien", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> dangKySinhVien(@Valid @RequestBody DangKyRequest request) {
        return authService.dangKy(request, "SINH_VIEN");
    }

    @PostMapping(value = "/dang-ky/giao-vien", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> dangKyGiaoVien(@Valid @RequestBody DangKyRequest request) {
        return authService.dangKy(request, "GIAO_VIEN");
    }

    @Operation(
        summary = "Login user",
        description = "Authenticate user and return JWT token",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successful login",
                content = @Content(schema = @Schema(implementation = DangNhapResponse.class))
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Invalid credentials"
            )
        }
    )
    @PostMapping("/dang-nhap")
    public ResponseEntity<?> dangNhap(@Valid @RequestBody DangNhapRequest request) {
        return authService.dangNhap(request);
    }

    @PostMapping("/dang-xuat")
    public ResponseEntity<?> dangXuat(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                // Lấy thời gian hết hạn từ token
                Long expirationTime = jwtService.getExpirationTimeFromToken(token);
                // Thêm token vào blacklist
                blacklistedTokenRepository.blacklist(token, expirationTime);
                
                return ResponseEntity.ok("Đăng xuất thành công");
            }
            return ResponseEntity.badRequest().body("Token không hợp lệ");
        } catch (Exception e) {
            log.error("Lỗi đăng xuất: ", e);
            throw new RuntimeException("Có lỗi xảy ra khi đăng xuất");
        }
    }
} 