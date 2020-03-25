package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Answer;
import com.example.studysystem.mapper.AnswerMapper;
import com.example.studysystem.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName AnswerServiceImpl
 * @description
 * @date 2020/3/25 9:09
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public Page<Answer> findByPage(Integer page , Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Answer> s=answerMapper.findAll(of);
        return s;
    }

    @Override
    public Answer save(Answer answer){
        return answerMapper.save(answer);
    }

    @Override
    public Answer update(Answer answer){
        return answerMapper.save(answer);
    }

    @Override
    public void delete(Integer id){
        answerMapper.deleteById(id);
    }

    @Override
    public List<Answer> findByStudent_Id(Integer id){
        return answerMapper.findByStudent_Id(id);
    }

    @Override
    public  List<Answer> findAnswersByExaminationContent_Id(Long id){
        return answerMapper.findAnswersByExaminationContent_Id(id);
    }

    @Override
    public List<Answer> findAnswersByExamination_idAndStudent_id(Integer id1,Integer id2){
        return answerMapper.findAnswersByExamination_idAndStudent_id(id1,id2);
    }

    @Override
    public Integer COUNTAnswersByExamination_idAndStudent_id(Integer id1,Integer id2){
        return answerMapper.COUNTAnswersByExamination_idAndStudent_id(id1,id2);
    }
}
