package com.example.studysystem.mapper;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.ExaminationContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationContentMapper extends JpaRepository<ExaminationContent,Long> {
    List<ExaminationContent> findByChoiceQuestion_Id(Integer id);

    List<ExaminationContent> findByExamination_Id(Integer id);


}
