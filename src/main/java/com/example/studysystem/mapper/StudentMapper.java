package com.example.studysystem.mapper;

import com.example.studysystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Misaikun
 * @ClassName StudentMapper
 * @description StudentMapper
 * @date 2020/2/17 10:33
 */

public interface  StudentMapper extends JpaRepository<Student,Integer> {
    Student findByName(String name);
}
