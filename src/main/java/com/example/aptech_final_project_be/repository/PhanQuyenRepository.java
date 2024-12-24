package com.example.aptech_final_project_be.repository;

import com.example.aptech_final_project_be.model.PhanQuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanQuyenRepository extends JpaRepository<PhanQuyen, Long> {
} 