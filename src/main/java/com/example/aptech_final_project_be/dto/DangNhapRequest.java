package com.example.aptech_final_project_be.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Login Request")
@Data
public class DangNhapRequest {
    @Schema(description = "Username", example = "sinhvien1")
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDangNhap;

    @Schema(description = "Password", example = "123456")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
} 