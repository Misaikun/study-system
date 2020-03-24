package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.Grade;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.GradeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByName")
    @ApiOperation(value = "查询年级",notes = "根据name查询")
    @WebLog(description = "根据年级名查找年级接口")
    public CommonResult<Grade> findByName(String name){
        Grade grade = gradeService.findByName(name);
        return new CommonResult<Grade>(ResultEnum.SUCCESS.getCode(),"findByName",grade);
    }

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有年级")
    @WebLog(description = "分页查询所有年级接口")
    public  CommonResult<Page<Grade>> findByPage(@RequestParam int page){
        if(page==0)
            page=1;
        Page<Grade> gradePage = gradeService.findByPage(page-1,2);
        return new CommonResult<Page<Grade>>(ResultEnum.SUCCESS.getCode(),"findByPage",gradePage);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存年级")
    @WebLog(description = "保存年级接口")
    public  CommonResult<Grade> save(@RequestBody Grade grade){
        Grade grade1 = gradeService.save(grade);
        return new CommonResult<Grade>(ResultEnum.SUCCESS.getCode(),"save",grade1);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新年级")
    @WebLog(description = "更新年级接口")
    public  CommonResult<Grade> update(@RequestBody Grade grade){
        Grade grade1 = gradeService.update(grade);
        return new CommonResult<Grade>(ResultEnum.SUCCESS.getCode(),"update",grade1);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除年级")
    @WebLog(description = "删除年级接口")
    public  CommonResult<Integer> delete(@RequestParam int id) {
        gradeService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

}
