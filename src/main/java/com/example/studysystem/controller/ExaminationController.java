package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.Examination;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.ExaminationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Misaikun
 * @ClassName ExaminationController
 * @description
 * @date 2020/3/18 20:51
 */

@RestController
@RequestMapping("/Examination")
@Api(value = "试卷控制类")
public class ExaminationController {
    @Autowired
    private ExaminationServiceImpl examinationService;

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有考试",notes = "根据page和size查询")
    @WebLog(description = "分页查询所有考试")
    public CommonResult<Page<Examination>> findByPage(@RequestParam Integer page , @RequestParam Integer size){
        if(page==0)
            page=1;
        Page<Examination> page1 = examinationService.findByPage(page-1,size);
        return new CommonResult<Page<Examination>>(ResultEnum.SUCCESS.getCode(),"findByPage",page1);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存一个考试",notes = "save Examination")
    @WebLog(description = "save Examination")
    public CommonResult<Examination> save(@RequestBody Examination examination){
        Examination examination1 = examinationService.save(examination);
        return new CommonResult<Examination>(ResultEnum.SUCCESS.getCode(),"save",examination1);
    }

    @PostMapping("/update")
    @ApiOperation(value = "保存一个考试",notes = "save Examination")
    @WebLog(description = "save Examination")
    public CommonResult<Examination> update(@RequestBody Examination examination){
        Examination examination1 = examinationService.update(examination);
        return new CommonResult<Examination>(ResultEnum.SUCCESS.getCode(),"update",examination1);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除考试",notes = "delete")
    @WebLog(description = "删除一个考试")
    public CommonResult<Integer> delete(@RequestParam Integer id){

        examinationService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

}
