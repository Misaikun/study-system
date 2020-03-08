package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.Student;
import com.example.studysystem.service.impl.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Misaikun
 * @ClassName StudentController
 * @description
 * @date 2020/3/6 15:42
 */
@RestController
@RequestMapping("/Student")
@Api(value = "学生控制类")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/findByName")
    @ApiOperation(value = "查询单个学生",notes = "根据name查询")
    @WebLog(description = "根据学生名字查找学生接口")
    public Student findByName(String name){
        return studentService.findByName(name);
    }

    @RequestMapping("/findByPage")
    @ApiOperation(value="分页查询所有学生")
    @WebLog(description = "分页查询所有学生")
    public Page<Student> findByPage(int page){
        if(page==0)
            page=1;
        return studentService.findByPage(page-1,2);
    }

    @PostMapping("/save")
    @WebLog(description = "保存学生接口")
    public Student save(@RequestBody Student student){
        System.out.println(student.getName());
        return this.studentService.save(student);
    }
    //修改
    @GetMapping("/update")
    @WebLog(description = "更新学生接口")
    public Student update(Student student){
        return studentService.update(student);
    }
    //删除
    @GetMapping("delete")
    @WebLog(description = "删除学生接口")
    public int delete(Integer id){
        try {
            studentService.delete(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
