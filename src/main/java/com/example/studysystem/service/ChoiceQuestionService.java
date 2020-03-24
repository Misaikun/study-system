package com.example.studysystem.service;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.ExaminationContent;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChoiceQuestionService {

    Page<ChoiceQuestion> findByPage(Integer page , Integer size);

    ChoiceQuestion save(ChoiceQuestion choiceQuestion);

    ChoiceQuestion update(ChoiceQuestion choiceQuestion);

    void delete(Integer id);

    List<ChoiceQuestion> findAllByKnowledge_Name(String name);

    List<ChoiceQuestion> findChoiceQuestionsByExamination_id(Integer id);
}
