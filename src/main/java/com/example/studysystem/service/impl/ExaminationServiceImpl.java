package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Examination;
import com.example.studysystem.mapper.ExaminationMapper;
import com.example.studysystem.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Misaikun
 * @ClassName ExaminationServiceImpl
 * @description
 * @date 2020/3/16 23:02
 */

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationMapper examinationMapper;

    @Override
    public Page<Examination> findByPage(Integer page , Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Examination> s = examinationMapper.findAll(of);
        return s;}

    @Override
    public Examination save(Examination examination){return examinationMapper.save(examination);}

    @Override
    public Examination update(Examination examination){return examinationMapper.save(examination);}

    @Override
    public void delete(Integer id){ examinationMapper.deleteById(id);}
}
