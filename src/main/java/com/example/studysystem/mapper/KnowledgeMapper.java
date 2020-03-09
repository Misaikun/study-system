package com.example.studysystem.mapper;

import com.example.studysystem.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeMapper extends JpaRepository<Knowledge,Integer> {
}
