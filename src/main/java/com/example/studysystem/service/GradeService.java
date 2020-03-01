package com.example.studysystem.service;

import com.example.studysystem.entity.Grade;
import org.springframework.data.domain.Page;

public interface GradeService {
    Page<Grade> findByPage(Integer page,Integer size);

    Grade save(Grade grade);

    Grade update(Grade grade);

    void delete(Integer id);

    Grade findByName(String name);
}
