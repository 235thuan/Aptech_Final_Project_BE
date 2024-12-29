package com.example.aptech_final_project_be.dto.response;

import com.example.aptech_final_project_be.model.ChiTietMonHoc;

import java.math.BigDecimal;
import java.util.List;

// DTO để trả về thông tin học phí
public class HocPhiResponse {
    private String tenItem;
    private BigDecimal giaTien;
    private List<ChiTietMonHoc> danhSachMonHoc; // chỉ dùng cho chuyên ngành

    public HocPhiResponse() {
    }

    public String getTenItem() {
        return tenItem;
    }

    public void setTenItem(String tenItem) {
        this.tenItem = tenItem;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public List<ChiTietMonHoc> getDanhSachMonHoc() {
        return danhSachMonHoc;
    }

    public void setDanhSachMonHoc(List<ChiTietMonHoc> danhSachMonHoc) {
        this.danhSachMonHoc = danhSachMonHoc;
    }
}
