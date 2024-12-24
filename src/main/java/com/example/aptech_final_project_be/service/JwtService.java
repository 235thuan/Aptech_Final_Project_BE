package com.example.aptech_final_project_be.service;

import com.example.aptech_final_project_be.model.NguoiDung;
import com.example.aptech_final_project_be.repository.BlacklistedTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtService {
    // Khóa bí mật để ký JWT
    @Value("${jwt.secret}")
    private String jwtSecret;

    private BlacklistedTokenRepository blacklistedTokenRepository;

    // Thời gian hết hạn token (24 giờ)
    private final long JWT_EXPIRATION = 86400000L;

    // Tạo JWT token từ thông tin người dùng
    public String generateToken(NguoiDung nguoiDung) {
        try {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

            // Lấy danh sách vai trò của người dùng
            List<String> roles = nguoiDung.getPhanQuyens().stream()
                .map(pq -> pq.getVaiTro().getTenVaiTro())
                .collect(Collectors.toList());

            return Jwts.builder()
                .setSubject(nguoiDung.getTenDangNhap())
                .claim("roles", roles)
                .claim("userId", nguoiDung.getIdNguoiDung())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
        } catch (Exception e) {
            log.error("Lỗi khi tạo JWT token: ", e);
            throw new RuntimeException("Không thể tạo JWT token");
        }
    }

    // Lấy username từ JWT token
    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            log.error("Lỗi khi đọc username từ token: ", e);
            return null;
        }
    }

    // Kiểm tra token có hợp lệ không
    public boolean validateToken(String token) {
        try {
            // Kiểm tra token có trong blacklist không
            if (blacklistedTokenRepository.isBlacklisted(token)) {
                return false;
            }
            
            Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error("Token không hợp lệ: ", e);
            return false;
        }
    }

    public Long getExpirationTimeFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token)
                .getBody();
            return claims.getExpiration().getTime();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi đọc token");
        }
    }
} 