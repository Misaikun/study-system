package com.example.studysystem.service;

import com.example.studysystem.entity.ClassInfo;
import org.springframework.data.domain.Page;

public interface ClassInfoService {

    Page<ClassInfo> findByPage(Integer page,Integer size);

    ClassInfo save(ClassInfo classInfo);

    ClassInfo update(ClassInfo classInfo);

    void delete(Integer id);

    ClassInfo findByName(String name);
}
