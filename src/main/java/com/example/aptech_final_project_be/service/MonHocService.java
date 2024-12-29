package com.example.aptech_final_project_be.service;

import com.example.aptech_final_project_be.exception.ResourceNotFoundException;
import com.example.aptech_final_project_be.model.MonHoc;
import com.example.aptech_final_project_be.repository.MonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;

    public MonHoc getById(Long id) {
        return monHocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy môn học với id: " + id));
    }
}
