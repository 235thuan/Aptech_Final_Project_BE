package com.example.aptech_final_project_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chitietchuyennganh")
public class ChiTietChuyenNganh {
    @Id
    @Column(name = "id_chitiet")
    private Long idChiTiet;

    @Column(name = "id_chuyennganh")
    private Long idChuyenNganh;

    @Column(name = "id_monhoc")
    private Long idMonHoc;

    public ChiTietChuyenNganh() {
    }

    public Long getIdChiTiet() {
        return idChiTiet;
    }

    public void setIdChiTiet(Long idChiTiet) {
        this.idChiTiet = idChiTiet;
    }

    public Long getIdChuyenNganh() {
        return idChuyenNganh;
    }

    public void setIdChuyenNganh(Long idChuyenNganh) {
        this.idChuyenNganh = idChuyenNganh;
    }

    public Long getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(Long idMonHoc) {
        this.idMonHoc = idMonHoc;
    }
// getters, setters, constructors
}
