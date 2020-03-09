package com.example.studysystem.service;

import com.example.studysystem.entity.Knowledge;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KnowledgeService {
    Page<Knowledge> findByPage(Integer page,Integer size);

    Knowledge save(Knowledge knowledge);

    Knowledge update(Knowledge knowledge);

    void delete(Integer id);


}
