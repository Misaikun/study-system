package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.ClassInfo;
import com.example.studysystem.service.impl.ClassInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Misaikun
 * @ClassName CllassInfoController
 * @description
 * @date 2020/3/6 15:42
 */
@RestController
@RequestMapping("/ClassInfo")
@Api(value = "班级控制类")
public class ClassInfoController {
    @Autowired
    ClassInfoServiceImpl classInfoService;

    @RequestMapping("/findByName")
    @ApiOperation(value = "查询班级",notes = "根据name查询")
    @WebLog(description = "根据班级名查找班级接口")
    public ClassInfo findByName(String name){return classInfoService.findByName(name);}

    @RequestMapping("/findByPage")
    @ApiOperation(value = "分页查询所有班级")
    @WebLog(description = "分页查询所有班级接口")
    public Page<ClassInfo> findByPage(int page){
        if(page==0)
            page=1;
        return classInfoService.findByPage(page-1,2);
    }

    @RequestMapping("/save")
    @ApiOperation(value = "保存班级")
    @WebLog(description = "保存班级接口")
    public ClassInfo save(ClassInfo grade){
        return classInfoService.save(grade);
    }

    @RequestMapping("/update")
    @ApiOperation(value = "更新班级")
    @WebLog(description = "更新班级接口")
    public ClassInfo update(ClassInfo grade){
        return classInfoService.update(grade);
    }

    @RequestMapping("/delete")
    @ApiOperation(value = "删除班级")
    @WebLog(description = "删除班级接口")
    public void delete(int id){
        classInfoService.delete(id);
    }
}
