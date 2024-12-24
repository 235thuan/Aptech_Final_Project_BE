package com.example.aptech_final_project_be.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nguoidung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"sinhVien", "giaoVien", "phanQuyens"})
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nguoidung")
    private Long idNguoiDung;
    
    @Column(name = "ten_dang_nhap", unique = true)
    private String tenDangNhap;
    
    @Column(name = "mat_khau")
    private String matKhau;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    
    @Column(name = "trang_thai")
    private String trangThai = "hoạt động";
    
    @OneToOne(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private SinhVien sinhVien;

    @OneToOne(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private GiaoVien giaoVien;

    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private Set<PhanQuyen> phanQuyens = new HashSet<>();

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
        if (sinhVien != null) {
            sinhVien.setNguoiDung(this);
        }
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
        if (giaoVien != null) {
            giaoVien.setNguoiDung(this);
        }
    }
}