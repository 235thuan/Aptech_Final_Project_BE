package com.example.aptech_final_project_be.dto.request;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DangKyRequest {
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDangNhap;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String matKhau;

    @Email(message = "Email không hợp lệ")
    private String email;

    private String soDienThoai;

    // Thông tin cho sinh viên
    private String tenSinhVien;
    private String lop;
    private Integer maChuyenNganh;
    private Integer namVaoHoc;

    // Thông tin cho giáo viên
    private String tenGiaoVien;
    private Integer maKhoa;
} 