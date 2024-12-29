package com.example.aptech_final_project_be.repository;

import com.example.aptech_final_project_be.model.ChiTietChuyenNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChiTietChuyenNganh, Long> {
    // Lấy danh sách môn học theo chuyên ngành
    @Query("SELECT c.idMonHoc FROM ChiTietChuyenNganh c WHERE c.idChuyenNganh = :idChuyenNganh")
    List<Long> findMonHocByChuyenNganh(Long idChuyenNganh);
}
