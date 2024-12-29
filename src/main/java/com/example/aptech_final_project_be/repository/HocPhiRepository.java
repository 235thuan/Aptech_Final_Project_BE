package com.example.aptech_final_project_be.repository;

import com.example.aptech_final_project_be.model.ChiTietHocPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HocPhiRepository extends JpaRepository<ChiTietHocPhi, Long> {
    // Tìm học phí theo môn học
    @Query("SELECT c FROM ChiTietHocPhi c WHERE c.idMonHoc = :idMonHoc")
    Optional<ChiTietHocPhi> findByIdMonHoc(Long idMonHoc);
}

