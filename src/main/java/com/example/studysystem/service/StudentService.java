package com.example.studysystem.service;

import com.example.studysystem.entity.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<Student> findByPage(Integer page, Integer size);
    Student update(Student student);
    Student save(Student student);
    void delete(Integer id);

    Student findByName(String name);
}
