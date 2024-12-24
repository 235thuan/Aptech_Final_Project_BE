package com.example.aptech_final_project_be.repository;

import com.example.aptech_final_project_be.model.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {
    Optional<VaiTro> findByTenVaiTro(String tenVaiTro);
} 