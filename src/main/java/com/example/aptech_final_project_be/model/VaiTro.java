package com.example.aptech_final_project_be.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "vaitro")
@Data
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaitro")
    private Long idVaiTro;

    @Column(name = "ten_vaitro")
    private String tenVaiTro;

    @Column(name = "mo_ta_vaitro")
    private String moTaVaiTro;

    public Long getIdVaiTro() {
        return idVaiTro;
    }

    public void setIdVaiTro(Long idVaiTro) {
        this.idVaiTro = idVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public String getMoTaVaiTro() {
        return moTaVaiTro;
    }

    public void setMoTaVaiTro(String moTaVaiTro) {
        this.moTaVaiTro = moTaVaiTro;
    }
}