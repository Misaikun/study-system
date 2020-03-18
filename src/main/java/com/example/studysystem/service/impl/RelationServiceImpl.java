package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Relation;
import com.example.studysystem.mapper.RelationMapper;
import com.example.studysystem.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Misaikun
 * @ClassName RelationServiceImpl
 * @description
 * @date 2020/3/17 16:50
 */
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public Page<Relation> findByPage(Integer page, Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Relation> r = relationMapper.findAll(of);
        return r;
    }

    @Override
    public Relation update(Relation relation){
        return relationMapper.save(relation);
    }

    @Override
    public Relation save(Relation relation){
        return relationMapper.save(relation);
    }

    @Override
    public void delete(Integer id){
        relationMapper.deleteById(id);
    }
}
