package com.example.aptech_final_project_be.service;

import com.example.aptech_final_project_be.exception.HocPhiException;
import com.example.aptech_final_project_be.exception.ResourceNotFoundException;
import com.example.aptech_final_project_be.repository.ChuyenNganhRepository;
import com.example.aptech_final_project_be.repository.HocPhiRepository;
import com.example.aptech_final_project_be.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class HocPhiService {
    @Autowired
    private HocPhiRepository hocPhiRepo;
    @Autowired private ChuyenNganhRepository chuyenNganhRepo;
    @Autowired private MonHocRepository monHocRepo;

    // Tính giá môn học
    public BigDecimal tinhGiaMonHoc(Long idMonHoc) {
        try {
            return hocPhiRepo.findByIdMonHoc(idMonHoc)
                    .map(hp -> hp.getSoTien().multiply(
                            BigDecimal.valueOf(monHocRepo.findById(idMonHoc)
                                    .map(MonHoc::getSoTinChi)
                                    .orElse(0))))
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy học phí cho môn học này"));
        } catch (Exception e) {
            throw new HocPhiException("Lỗi khi tính học phí môn học", e);
        }
    }

    // Tính giá chuyên ngành
    public BigDecimal tinhGiaChuyenNganh(Long idChuyenNganh) {
        try {
            List<Long> dsMonHoc = chuyenNganhRepo.findMonHocByChuyenNganh(idChuyenNganh);
            return dsMonHoc.stream()
                    .map(this::tinhGiaMonHoc)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } catch (Exception e) {
            throw new HocPhiException("Lỗi khi tính học phí chuyên ngành", e);
        }
    }
}
