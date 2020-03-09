package com.example.studysystem.mapper;

import com.example.studysystem.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationMapper extends JpaRepository<Examination,Integer> {
}
