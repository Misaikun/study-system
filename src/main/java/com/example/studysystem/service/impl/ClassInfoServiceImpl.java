package com.example.studysystem.service.impl;

import com.example.studysystem.entity.ClassInfo;
import com.example.studysystem.mapper.ClassInfoMapper;
import com.example.studysystem.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Misaikun
 * @ClassName ClassInfoService
 * @description
 * @date 2020/3/1 15:50
 */
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public ClassInfo save(ClassInfo classInfo){
        return classInfoMapper.save(classInfo);
    }

    @Override
    public ClassInfo update(ClassInfo classInfo){
        return classInfoMapper.save(classInfo);
    }

    @Override
    public void delete(Integer id){
        classInfoMapper.deleteById(id);
    }

    @Override
    public Page<ClassInfo> findByPage(Integer page,Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<ClassInfo> s=classInfoMapper.findAll(of);
        return s;
    }

    @Override
    public ClassInfo findByName(String name){
        return classInfoMapper.findByName(name);
    }

}
