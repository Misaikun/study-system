package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.Grade;
import com.example.studysystem.service.impl.GradeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Misaikun
 * @ClassName GradeCrontroller
 * @description
 * @date 2020/3/6 15:42
 */

@RestController
@RequestMapping("/Grade")
@Api(value = "年级控制类")
public class GradeController {
    @Autowired
    private GradeServiceImpl gradeService;

    @RequestMapping("/findByName")
    @ApiOperation(value = "查询年级",notes = "根据name查询")
    @WebLog(description = "根据年级名查找年级接口")
    public Grade findByName(String name){return gradeService.findByName(name);}

    @RequestMapping("/findByPage")
    @ApiOperation(value = "分页查询所有年级")
    @WebLog(description = "分页查询所有年级接口")
    public Page<Grade> findByPage(@RequestParam int page){
        if(page==0)
            page=1;
        return gradeService.findByPage(page-1,2);
    }

    @RequestMapping("/save")
    @ApiOperation(value = "保存年级")
    @WebLog(description = "保存年级接口")
    public Grade save(@RequestBody Grade grade){
        return gradeService.save(grade);
    }

    @RequestMapping("/update")
    @ApiOperation(value = "更新年级")
    @WebLog(description = "更新年级接口")
    public Grade update(@RequestBody Grade grade){
        return gradeService.update(grade);
    }

    @RequestMapping("/delete")
    @ApiOperation(value = "删除年级")
    @WebLog(description = "删除年级接口")
    public void delete(@RequestParam int id){
        gradeService.delete(id);
    }

}
