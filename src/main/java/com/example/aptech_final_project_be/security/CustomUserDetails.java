package com.example.aptech_final_project_be.security;

import com.example.aptech_final_project_be.model.NguoiDung;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private NguoiDung nguoiDung;
    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails build(NguoiDung nguoiDung) {
        List<GrantedAuthority> authorities = nguoiDung.getPhanQuyens().stream()
                .map(pq -> {
                    String roleName = pq.getVaiTro().getTenVaiTro()
                        .toUpperCase()
                        .replace(" ", "_")
                        .replace("Á", "A")
                        .replace("À", "A")
                        .replace("Ả", "A")
                        .replace("Ã", "A")
                        .replace("Ạ", "A")
                        .replace("Â", "A")
                        .replace("Ấ", "A")
                        .replace("Ầ", "A")
                        .replace("Ẩ", "A")
                        .replace("Ẫ", "A")
                        .replace("Ậ", "A")
                        .replace("Ă", "A")
                        .replace("Ắ", "A")
                        .replace("Ằ", "A")
                        .replace("Ẳ", "A")
                        .replace("Ẵ", "A")
                        .replace("Ặ", "A")
                        .replace("É", "E")
                        .replace("È", "E")
                        .replace("Ẻ", "E")
                        .replace("Ẽ", "E")
                        .replace("Ẹ", "E")
                        .replace("Ê", "E")
                        .replace("Ế", "E")
                        .replace("Ề", "E")
                        .replace("Ể", "E")
                        .replace("Ễ", "E")
                        .replace("Ệ", "E")
                        .replace("Í", "I")
                        .replace("Ì", "I")
                        .replace("Ỉ", "I")
                        .replace("Ĩ", "I")
                        .replace("Ị", "I")
                        .replace("Ó", "O")
                        .replace("Ò", "O")
                        .replace("Ỏ", "O")
                        .replace("Õ", "O")
                        .replace("Ọ", "O")
                        .replace("Ô", "O")
                        .replace("Ố", "O")
                        .replace("Ồ", "O")
                        .replace("Ổ", "O")
                        .replace("Ỗ", "O")
                        .replace("Ộ", "O")
                        .replace("Ơ", "O")
                        .replace("Ớ", "O")
                        .replace("Ờ", "O")
                        .replace("Ở", "O")
                        .replace("Ỡ", "O")
                        .replace("Ợ", "O")
                        .replace("Ú", "U")
                        .replace("Ù", "U")
                        .replace("Ủ", "U")
                        .replace("Ũ", "U")
                        .replace("Ụ", "U")
                        .replace("Ư", "U")
                        .replace("Ứ", "U")
                        .replace("Ừ", "U")
                        .replace("Ử", "U")
                        .replace("Ữ", "U")
                        .replace("Ự", "U")
                        .replace("Ý", "Y")
                        .replace("Ỳ", "Y")
                        .replace("Ỷ", "Y")
                        .replace("Ỹ", "Y")
                        .replace("Ỵ", "Y")
                        .replace("Đ", "D");
                    return new SimpleGrantedAuthority("ROLE_" + roleName);
                })
                .collect(Collectors.toList());

        return new CustomUserDetails(nguoiDung, authorities);
    }

    public Long getId() {
        return nguoiDung.getIdNguoiDung();
    }

    @Override
    public String getPassword() {
        return nguoiDung.getMatKhau();
    }

    @Override
    public String getUsername() {
        return nguoiDung.getTenDangNhap();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return nguoiDung.getTrangThai().equals("hoạt động");
    }
} 