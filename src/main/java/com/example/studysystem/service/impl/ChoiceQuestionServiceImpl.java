package com.example.studysystem.service.impl;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.ClassInfo;
import com.example.studysystem.mapper.ChoiceQuestionMapper;
import com.example.studysystem.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName ChoiceQuestionServiceImpl
 * @description
 * @date 2020/3/9 9:55
 */
@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {
    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;

    @Override
    public Page<ChoiceQuestion> findByPage(Integer page , Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<ChoiceQuestion> s=choiceQuestionMapper.findAll(of);
        return s;
    }
    @Override
    public ChoiceQuestion save(ChoiceQuestion choiceQuestion){
        return choiceQuestionMapper.save(choiceQuestion);
    }

    @Override
    public ChoiceQuestion update(ChoiceQuestion choiceQuestion){
        return choiceQuestionMapper.save(choiceQuestion);
    }

    @Override
    public void delete(Integer id){
        choiceQuestionMapper.deleteById(id);
    }

    @Override
    public List<ChoiceQuestion> findAllByKnowledge_Name(String name){
        return choiceQuestionMapper.findAllByKnowledge_Name(name);
    }
}
