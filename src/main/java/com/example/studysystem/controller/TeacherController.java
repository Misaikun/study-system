package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
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
    private TeacherServiceImpl teacherService;

    @GetMapping("/findByName")
    @ApiOperation(value = "查询单个教师",notes = "根据name查询")
    @WebLog(description = "根据教师名字查找教师接口")
    public CommonResult<Teacher> findByName(@RequestParam String name){
        Teacher teacher = teacherService.findByName(name);
        return new CommonResult<Teacher>(ResultEnum.SUCCESS.getCode(),"findByName",teacher);
    }

    //分页查询
    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有教师",notes = "分页查询所有教师")
    @WebLog(description = "分页查找所有教师")
    public CommonResult<Page<Teacher>> findByPage(@RequestParam int page){
        if(page==0)
            page=1;
        Page<Teacher> teacherPage = teacherService.findByPage(page-1,2);
        return new CommonResult<Page<Teacher>>(ResultEnum.SUCCESS.getCode(),"findByPage",teacherPage);
    }
    //新增
    @PostMapping("/save")
    @WebLog(description = "保存教师接口")
    public CommonResult<Teacher> save(@RequestBody Teacher teacher){
        Teacher teacher1 = teacherService.save(teacher);
        return new CommonResult<Teacher>(ResultEnum.SUCCESS.getCode(),"save",teacher1);
    }
    //修改
    @GetMapping("/update")
    @WebLog(description = "更新教师接口")
    public CommonResult<Teacher> update(@RequestBody Teacher teacher2){
        Teacher teacher = teacherService.update(teacher2);
        return new CommonResult<Teacher>(ResultEnum.SUCCESS.getCode(),"save",teacher);
    }
    //删除
    @GetMapping("delete")
    @WebLog(description = "删除教师接口")
    public CommonResult<Integer> delete(@RequestParam Integer id){
        teacherService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }
}