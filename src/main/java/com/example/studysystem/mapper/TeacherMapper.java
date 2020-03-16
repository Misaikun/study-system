package com.example.studysystem.mapper;

import com.example.studysystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Misaikun
 * @ClassName TeacherMapper
 * @description
 * @date 2020/1/19 10:09
 */
@Repository
public interface  TeacherMapper extends JpaRepository<Teacher,Integer> {
    Teacher findByName(String name);
}
