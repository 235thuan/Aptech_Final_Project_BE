package com.example.aptech_final_project_be.model;

import java.math.BigDecimal;
import java.util.Date;

public class GioHang {
    private Long id;
    private Long idNguoiDung;
    private String loaiMua; // "MONHOC" hoặc "CHUYENNGANH"
    private Long idItem;
    private BigDecimal tongTien;
    private Date ngayTao;

    public GioHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Long idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getLoaiMua() {
        return loaiMua;
    }

    public void setLoaiMua(String loaiMua) {
        this.loaiMua = loaiMua;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
}
