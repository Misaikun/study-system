package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Grade;
import com.example.studysystem.mapper.GradeMapper;
import com.example.studysystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Misaikun
 * @ClassName GradeServiceImpl
 * @description
 * @date 2020/3/1 15:47
 */
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public Page<Grade> findByPage(Integer page,Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Grade> s=gradeMapper.findAll(of);
        return s;
    }
    @Override
    public Grade save(Grade grade){
        return gradeMapper.save(grade);
    }

    @Override
    public Grade update(Grade grade){
        return gradeMapper.save(grade);
    }

    @Override
    public void delete(Integer id){
        gradeMapper.deleteById(id);
    }

    @Override
    public Grade findByName(String name){
        return gradeMapper.findByName(name);
    }
}
