package com.example.studysystem.service;

import com.example.studysystem.entity.Examination;
import org.springframework.data.domain.Page;

public interface ExaminationService {
    Page<Examination> findByPage(Integer page , Integer size);

    Examination save(Examination examination);

    Examination update(Examination examination);

    void delete(Integer id);
}
