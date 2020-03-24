package com.example.studysystem.service;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.Examination;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExaminationService {
    Page<Examination> findByPage(Integer page , Integer size);

    Examination save(Examination examination);

    Examination update(Examination examination);

    void delete(Integer id);


}
