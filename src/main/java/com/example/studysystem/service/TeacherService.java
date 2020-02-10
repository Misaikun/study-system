package com.example.studysystem.service;

import com.example.studysystem.entity.Teacher;
import org.springframework.data.domain.Page;

public interface TeacherService {
    Page<Teacher> findByPage(Integer page, Integer size);
    Teacher save(Teacher user);
    Teacher update(Teacher user);
    void delete(Integer id);
    Teacher findByName(String name);
}
