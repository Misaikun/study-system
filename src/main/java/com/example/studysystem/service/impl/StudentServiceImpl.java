package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Student;
import com.example.studysystem.mapper.StudentMapper;
import com.example.studysystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Misaikun
 * @ClassName StudentServiceImpl
 * @description
 * @date 2020/2/17 11:19
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Page<Student> findByPage(Integer page, Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Student> s = studentMapper.findAll(of);
        return s;
    }

    @Override
    public Student update(Student student){
        return studentMapper.save(student);
    }

    @Override
    public Student save(Student student){
        return studentMapper.save(student);
    }

    @Override
    public void delete(Integer id){
        studentMapper.deleteById(id);
    }

    @Override
    public Student findByName(String name){
        return studentMapper.findByName(name);
    }

}
