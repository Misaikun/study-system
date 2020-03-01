package com.example.studysystem.mapper;

import com.example.studysystem.entity.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Misaikun
 * @ClassName ClassInfoMapper
 * @description
 * @date 2020/3/1 15:53
 */
public interface ClassInfoMapper extends JpaRepository<ClassInfo,Integer> {
    ClassInfo findByName(String name);
}
