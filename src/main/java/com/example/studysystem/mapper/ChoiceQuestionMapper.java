package com.example.studysystem.mapper;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.ExaminationContent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChoiceQuestionMapper extends JpaRepository<ChoiceQuestion,Integer> {

    List<ChoiceQuestion> findAllByKnowledge_Name(String name);

    @Query(nativeQuery = true , value = "SELECT DISTINCT c.* FROM examination_content a INNER  JOIN choice_question c ON a.examination_id = ? ")
    List<ChoiceQuestion> findChoiceQuestionsByExamination_id(Integer id);
}
