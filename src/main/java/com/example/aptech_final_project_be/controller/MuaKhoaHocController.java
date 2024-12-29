package com.example.aptech_final_project_be.controller;

import com.example.aptech_final_project_be.dto.response.HocPhiResponse;
import com.example.aptech_final_project_be.exception.ApiException;
import com.example.aptech_final_project_be.exception.ResourceNotFoundException;
import com.example.aptech_final_project_be.exception.ThanhToanException;
import com.example.aptech_final_project_be.model.MonHoc;
import com.example.aptech_final_project_be.service.ChuyenNganhService;
import com.example.aptech_final_project_be.service.HocPhiService;
import com.example.aptech_final_project_be.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/muakhoahoc")
public class MuaKhoaHocController {
    @Autowired private HocPhiService hocPhiService;
    @Autowired private MonHocService monHocService;
    @Autowired private ChuyenNganhService chuyenNganhService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception e) {
        if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Lỗi hệ thống: " + e.getMessage());
    }

    @GetMapping("/monhoc/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HocPhiResponse> xemGiaMonHoc(@PathVariable Long id) {
        try {
            MonHoc monHoc = monHocService.getById(id);
            BigDecimal gia = hocPhiService.tinhGiaMonHoc(id);
            return ResponseEntity.ok(new HocPhiResponse(monHoc.getTenMonHoc(), gia));
        } catch (Exception e) {
            throw new ApiException("Lỗi khi lấy giá môn học: " + e.getMessage());
        }
    }

    @GetMapping("/chuyennganh/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<HocPhiResponse> xemGiaChuyenNganh(@PathVariable Long id) {
        try {
            ChuyenNganh chuyenNganh = chuyenNganhService.getById(id);
            BigDecimal gia = hocPhiService.tinhGiaChuyenNganh(id);
            return ResponseEntity.ok(new HocPhiResponse(chuyenNganh.getTenChuyenNganh(), gia));
        } catch (Exception e) {
            throw new ApiException("Lỗi khi lấy giá chuyên ngành: " + e.getMessage());
        }
    }
}