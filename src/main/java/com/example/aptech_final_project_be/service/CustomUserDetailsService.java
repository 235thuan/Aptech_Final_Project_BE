package com.example.aptech_final_project_be.service;

import com.example.aptech_final_project_be.model.NguoiDung;
import com.example.aptech_final_project_be.repository.NguoiDungRepository;
import com.example.aptech_final_project_be.security.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            NguoiDung nguoiDung = nguoiDungRepository.findByTenDangNhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng"));

            return CustomUserDetails.build(nguoiDung);
        } catch (Exception e) {
            log.error("Lỗi khi tải thông tin người dùng: ", e);
            throw new UsernameNotFoundException("Lỗi xác thực người dùng");
        }
    }
} 