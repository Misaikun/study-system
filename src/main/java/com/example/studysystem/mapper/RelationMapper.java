package com.example.studysystem.mapper;

import com.example.studysystem.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Misaikun
 * @ClassName RelationMapper
 * @description
 * @date 2020/3/16 17:16
 */
public interface RelationMapper extends JpaRepository<Relation,Integer> {
}
