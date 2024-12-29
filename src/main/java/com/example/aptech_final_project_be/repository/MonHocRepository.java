package com.example.aptech_final_project_be.repository;

import com.example.aptech_final_project_be.model.ChiTietHocPhi;
import com.example.aptech_final_project_be.model.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, Long> {
    // Các phương thức mặc định từ JpaRepository
}
