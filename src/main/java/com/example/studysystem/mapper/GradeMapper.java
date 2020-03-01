package com.example.studysystem.mapper;

import com.example.studysystem.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeMapper extends JpaRepository<Grade,Integer> {
    Grade findByName(String name);
}
