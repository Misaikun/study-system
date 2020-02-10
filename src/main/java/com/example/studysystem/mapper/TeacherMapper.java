package com.example.studysystem.mapper;

import com.example.studysystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Misaikun
 * @ClassName TeacherMapper
 * @description
 * @date 2020/1/19 10:09
 */
public interface  TeacherMapper extends JpaRepository<Teacher,Integer> {
    Teacher findByName(String name);
}
