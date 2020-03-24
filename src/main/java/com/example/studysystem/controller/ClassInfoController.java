package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.ClassInfo;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.ClassInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByName")
    @ApiOperation(value = "查询班级",notes = "根据name查询")
    @WebLog(description = "根据班级名查找班级接口")
    public CommonResult<ClassInfo> findByName(@RequestParam String name){
        ClassInfo classInfo = classInfoService.findByName(name);
        return new CommonResult<ClassInfo>(ResultEnum.SUCCESS.getCode(),"findByName",classInfo);
    }

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有班级")
    @WebLog(description = "分页查询所有班级接口")
    public CommonResult<Page<ClassInfo>> findByPage(@RequestParam int page){
        if(page==0)
            page=1;
        Page<ClassInfo> classInfos = classInfoService.findByPage(page-1,2);
        return new CommonResult<Page<ClassInfo>>(ResultEnum.SUCCESS.getCode(),"findByPage",classInfos);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存班级")
    @WebLog(description = "保存班级接口")
    public CommonResult<ClassInfo> save(@RequestBody ClassInfo classInfo){
        ClassInfo classInfo1 = classInfoService.save(classInfo);
        return new CommonResult<ClassInfo>(ResultEnum.SUCCESS.getCode(),"save",classInfo1);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新班级")
    @WebLog(description = "更新班级接口")
    public CommonResult<ClassInfo> update(@RequestBody ClassInfo classInfo){
        ClassInfo classInfo1 = classInfoService.update(classInfo);
        return new CommonResult<ClassInfo>(ResultEnum.SUCCESS.getCode(),"update",classInfo1);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除班级")
    @WebLog(description = "删除班级接口")
    public CommonResult<Integer> delete(@RequestParam int id){
        classInfoService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }
}
