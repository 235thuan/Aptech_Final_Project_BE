package com.example.aptech_final_project_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "chitiethocphi")
public class ChiTietHocPhi {
    @Id
    @Column(name = "id_chitiethocphi")
    private Long idChiTietHocPhi;

    @Column(name = "id_hocphi")
    private Long idHocPhi;

    @Column(name = "id_monhoc")
    private Long idMonHoc;

    @Column(name = "so_tien")
    private BigDecimal soTien;

    public ChiTietHocPhi() {
    }

    public Long getIdChiTietHocPhi() {
        return idChiTietHocPhi;
    }

    public void setIdChiTietHocPhi(Long idChiTietHocPhi) {
        this.idChiTietHocPhi = idChiTietHocPhi;
    }

    public Long getIdHocPhi() {
        return idHocPhi;
    }

    public void setIdHocPhi(Long idHocPhi) {
        this.idHocPhi = idHocPhi;
    }

    public Long getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(Long idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }
    // getters, setters, constructors
}
