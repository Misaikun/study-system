package com.example.studysystem.controller;

import com.example.studysystem.entity.Teacher;
import com.example.studysystem.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Misaikun
 * @ClassName TeacherController
 * @description
 * @date 2020/1/19 10:23
 */
@RestController
@Api(value = "教师控制类")
@RequestMapping("/Teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacher;

    @RequestMapping("/findByName")
    @ApiOperation(value = "查询单个教师",notes = "根据name查询")
    public Teacher findByName(String name){
        return teacher.findByName(name);
    }

    //分页查询
    @RequestMapping("/findByPage")
    @ApiOperation(value = "分页查询所有教师",notes = "分页查询所有教师")
    public Page<Teacher> findByPage(int page){
        if(page==0)
            page=1;
        return teacher.findByPage(page-1,2);
    }
    //新增
    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher){
        System.out.println(teacher.getName());
        return this.teacher.save(teacher);
    }
    //修改
    @GetMapping("/update")
    public Teacher update(Teacher student){
        return teacher.update(student);
    }
    //删除
    @GetMapping("delete")
    public int delete(Integer id){
        try {
            teacher.delete(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}