package com.example.aptech_final_project_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuyennganh")
public class ChuyenNganh {
    @Id
    @Column(name = "id_chuyennganh")
    private Long idChuyenNganh;

    @Column(name = "ten_chuyennganh")
    private String tenChuyenNganh;

    @Column(name = "id_khoa")
    private Long idKhoa;

    public ChuyenNganh() {
    }

    public Long getIdChuyenNganh() {
        return idChuyenNganh;
    }

    public void setIdChuyenNganh(Long idChuyenNganh) {
        this.idChuyenNganh = idChuyenNganh;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }

    public Long getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(Long idKhoa) {
        this.idKhoa = idKhoa;
    }
    // getters, setters, constructors
}
