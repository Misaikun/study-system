package com.example.studysystem.mapper;

import com.example.studysystem.entity.ChoiceQuestion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiceQuestionMapper extends JpaRepository<ChoiceQuestion,Integer> {

    List<ChoiceQuestion> findAllByKnowledge_Name(String name);
}
