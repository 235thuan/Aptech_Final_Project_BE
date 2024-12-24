package com.example.aptech_final_project_be.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "giaovien")
@Getter
@Setter
@ToString(exclude = "nguoiDung")
public class GiaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_giaovien")
    private Long idGiaoVien;

    @OneToOne
    @JoinColumn(name = "id_nguoidung")
    private NguoiDung nguoiDung;

    @Column(name = "ten_giaovien")
    private String tenGiaoVien;

    @Column(name = "ma_khoa")
    private Integer maKhoa;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;
}