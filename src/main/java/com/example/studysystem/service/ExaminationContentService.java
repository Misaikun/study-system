package com.example.studysystem.service;

import com.example.studysystem.entity.ExaminationContent;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExaminationContentService {
    Page<ExaminationContent> findByPage(Integer page , Integer size);

    ExaminationContent save(ExaminationContent examination);

    ExaminationContent update(ExaminationContent examination);

    void delete(Long id);

    List<ExaminationContent> findByChoiceQuestion_Id(Integer id);

    List<ExaminationContent> findByExamination_Id(Integer id);
}
