package com.example.aptech_final_project_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monhoc")
public class MonHoc {
    @Id
    @Column(name = "id_monhoc")
    private Long idMonHoc;

    @Column(name = "ten_monhoc")
    private String tenMonHoc;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    public MonHoc() {
    }

    public Long getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(Long idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }
    // getters, setters, constructors
}
