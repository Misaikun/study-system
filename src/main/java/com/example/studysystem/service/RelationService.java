package com.example.studysystem.service;

import com.example.studysystem.entity.Relation;
import org.springframework.data.domain.Page;

public interface RelationService {
    Page<Relation> findByPage(Integer page, Integer size);

    Relation update(Relation relation);

    Relation save(Relation relation);

    void delete(Integer id);

}
