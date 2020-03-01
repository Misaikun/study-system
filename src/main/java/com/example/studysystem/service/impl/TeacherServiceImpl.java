package com.example.studysystem.service;

import com.example.studysystem.entity.Teacher;
import com.example.studysystem.mapper.TeacherMapper;
import com.example.studysystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Misaikun
 * @ClassName TeacherServiceImpl
 * @description
 * @date 2020/1/19 9:28
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override//分页查询
    public Page<Teacher> findByPage(Integer page, Integer size) {
        PageRequest of=PageRequest.of(page,size);
        Page<Teacher> s=teacherMapper.findAll(of);
        return s;
    }
    @Override
    public Teacher findByName(String name){return  teacherMapper.findByName(name);}


    @Override//新增
    public Teacher save(Teacher user) {
        return teacherMapper.save(user);
    }

    @Override
    public Teacher update(Teacher user) {
        return teacherMapper.save(user);
    }

    @Override
    public void delete(Integer id) {
        teacherMapper.deleteById(id);
    }

}
