package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.entity.Student;
import com.example.studysystem.service.StudentService;
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
    private StudentService studentService;

    @GetMapping("/findByName")
    @ApiOperation(value = "查询单个学生",notes = "根据name查询")
    @WebLog(description = "根据学生名字查找学生接口")
    public CommonResult<Student> findByName(@RequestParam String name){
        Student student = studentService.findByName(name);
        return new CommonResult<Student>(ResultEnum.SUCCESS.getCode(),"findByName",student);
    }

    @GetMapping("/findByPage")
    @ApiOperation(value="分页查询所有学生")
    @WebLog(description = "分页查询所有学生")
    public CommonResult<Page<Student>> findByPage(@RequestParam int page){
        if(page==0)
            page=1;
        Page<Student> studentPage = studentService.findByPage(page-1,2);
        return new CommonResult<Page<Student>>(ResultEnum.SUCCESS.getCode(),"findByPage",studentPage);
    }

    @PostMapping("/save")
    @WebLog(description = "保存学生接口")
    public CommonResult<Student> save(@RequestBody Student student){
        System.out.println(student.getName());
        Student student1 = studentService.save(student);
        return new CommonResult<Student>(ResultEnum.SUCCESS.getCode(),"save",student1);
    }
    //修改
    @GetMapping("/update")
    @WebLog(description = "更新学生接口")
    public CommonResult<Student> update(@RequestBody Student student){
        Student student1 = studentService.update(student);
        return new CommonResult<Student>(ResultEnum.SUCCESS.getCode(),"update",student1);
    }
    //删除
    @GetMapping("delete")
    @WebLog(description = "删除学生接口")
    public CommonResult<Integer> delete(@RequestParam Integer id){
        studentService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }
}
