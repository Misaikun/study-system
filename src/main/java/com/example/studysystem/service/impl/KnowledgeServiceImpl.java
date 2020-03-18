package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Knowledge;
import com.example.studysystem.mapper.KnowledgeMapper;
import com.example.studysystem.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Misaikun
 * @ClassName KnowledgeServiceImpl
 * @description
 * @date 2020/3/9 22:01
 */

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    KnowledgeMapper knowledgeMapper;
    @Override
    public Page<Knowledge> findByPage(Integer page, Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Knowledge> s = knowledgeMapper.findAll(of);
        return s;
    }
    @Override
    public Knowledge save(Knowledge knowledge){
        return knowledgeMapper.save(knowledge);
    }

    @Override
    public Knowledge update(Knowledge knowledge){
        return knowledgeMapper.save(knowledge);
    }

    public void delete(Integer id){
        knowledgeMapper.deleteById(id );
    }
}
