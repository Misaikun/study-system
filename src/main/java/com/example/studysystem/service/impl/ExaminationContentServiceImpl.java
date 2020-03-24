package com.example.studysystem.service.impl;

import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.ExaminationContent;
import com.example.studysystem.mapper.ExaminationContentMapper;
import com.example.studysystem.service.ExaminationContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName ExaminationContentServiceImpl
 * @description
 * @date 2020/3/18 23:57
 */
@Service
public class ExaminationContentServiceImpl implements ExaminationContentService {
    @Autowired
    private ExaminationContentMapper examinationContentMapper;


    @Override
    public Page<ExaminationContent> findByPage(Integer page , Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<ExaminationContent> s = examinationContentMapper.findAll(of);
        return s;
    }

    @Override
    public ExaminationContent save(ExaminationContent examination){
        return examinationContentMapper.save(examination);
    }

    @Override
    public ExaminationContent update(ExaminationContent examination){
        return examinationContentMapper.save(examination);
    }

    @Override
    public void delete(Long id){
        examinationContentMapper.deleteById(id);
    }

    @Override
    public List<ExaminationContent> findByChoiceQuestion_Id(Integer id){
        return examinationContentMapper.findByChoiceQuestion_Id(id);
    }

    @Override
    public List<ExaminationContent> findByExamination_Id(Integer id){
        return examinationContentMapper.findByExamination_Id(id);
    }



}
