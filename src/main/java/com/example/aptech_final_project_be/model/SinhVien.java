package com.example.aptech_final_project_be.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sinhvien")
@Getter
@Setter
@ToString(exclude = "nguoiDung")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sinhvien")
    private Long idSinhVien;

    @OneToOne
    @JoinColumn(name = "id_nguoidung")
    private NguoiDung nguoiDung;

    @Column(name = "ten_sinhvien")
    private String tenSinhVien;

    @Column(name = "lop")
    private String lop;

    @Column(name = "ma_chuyen_nganh")
    private Integer maChuyenNganh;

    @Column(name = "nam_vao_hoc")
    private Integer namVaoHoc;
}