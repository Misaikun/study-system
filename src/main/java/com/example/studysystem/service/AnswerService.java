package com.example.studysystem.service;

import com.example.studysystem.entity.Answer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AnswerService {
    Page<Answer> findByPage(Integer page , Integer size);

    Answer save(Answer answer);

    Answer update(Answer answer);

    void delete(Integer id);

    List<Answer> findByStudent_Id(Integer id);

    List<Answer> findAnswersByExaminationContent_Id(Long id);

    List<Answer> findAnswersByExamination_idAndStudent_id(Integer id1,Integer id2);

    Integer COUNTAnswersByExamination_idAndStudent_id(Integer id1,Integer id2);
}
