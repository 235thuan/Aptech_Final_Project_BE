package com.example.aptech_final_project_be.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "phanquyen")
@Getter
@Setter
@ToString(exclude = {"nguoiDung", "vaiTro"})
public class PhanQuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phanquyen")
    private Long idPhanQuyen;

    @ManyToOne
    @JoinColumn(name = "id_nguoidung")
    private NguoiDung nguoiDung;

    @ManyToOne
    @JoinColumn(name = "id_vaitro")
    private VaiTro vaiTro;
}