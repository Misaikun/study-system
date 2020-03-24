package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ExaminationContent;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.ChoiceQuestionServiceImpl;
import com.example.studysystem.service.impl.ExaminationContentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Misaikun
 * @ClassName ExaminationContentController
 * @description
 * @date 2020/3/19 16:14
 */

@RestController
@RequestMapping("/ExaminationContent")
@Api(value = "试卷内容控制类")
public class ExaminationContentController {

    @Autowired
    private ExaminationContentServiceImpl examinationContentService;
    @Autowired
    private ChoiceQuestionServiceImpl choiceQuestionService;

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有考试的所有内容",notes = "根据page和size查询")
    @WebLog(description = "分页查询所有考试的所有内容")
    public CommonResult<Page<ExaminationContent>> findByPage(@RequestParam Integer page , @RequestParam Integer size){
        if(page==0)
            page=1;
        Page<ExaminationContent> contentPage = examinationContentService.findByPage(page-1,size);
        return new CommonResult<Page<ExaminationContent>>(ResultEnum.SUCCESS.getCode(),"findByPage",contentPage);
    }


    @PostMapping("/save")
    @ApiOperation(value = "创建/保存一个考试内容",notes = "一条考试内容记录")
    @WebLog(description = "save")
    public CommonResult<ExaminationContent> save(@RequestBody ExaminationContent examination){

        ExaminationContent examinationContent = examinationContentService.save(examination);
        return new CommonResult<ExaminationContent>(ResultEnum.SUCCESS.getCode(),"save",examinationContent);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新一个考试内容",notes = "更新一条考试内容记录")
    @WebLog(description = "update")
    public CommonResult<ExaminationContent> update(@RequestBody ExaminationContent examination){
        ExaminationContent examinationContent = examinationContentService.update(examination);
        return new CommonResult<ExaminationContent>(ResultEnum.SUCCESS.getCode(),"update",examinationContent);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除一条考试内容",notes = "delete")
    @WebLog(description = "delete")
    public CommonResult<Long> delete(@RequestParam Long id){
        examinationContentService.delete(id);
        return  new CommonResult<Long>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

    @GetMapping("/findByChoiceQuestion_Id")
    @ApiOperation(value = "根据试题id查询该试题所应用在的考试",notes = "findByChoiceQuestion_Id")
    @WebLog(description = "findByChoiceQuestion_Id")
    public CommonResult<List<ExaminationContent>> findByChoiceQuestion_Id(@RequestParam Integer id){
        List<ExaminationContent> contentList = examinationContentService.findByChoiceQuestion_Id(id);
        return new CommonResult<List<ExaminationContent>>(ResultEnum.SUCCESS.getCode(),"findByChoiceQuestion_Id",contentList);
    }

    @GetMapping("/findByExamination_Id")
    @ApiOperation(value = "根据考试id查询该次考试所有记录",notes = "findByExamination_Id")
    @WebLog(description = "findByExamination_Id")
    public CommonResult<List<ExaminationContent>> findByExamination_Id(@RequestParam Integer id){
        List<ExaminationContent> contentList = examinationContentService.findByExamination_Id(id);
        return new CommonResult<List<ExaminationContent>>(ResultEnum.SUCCESS.getCode(),"findByExamination_Id",contentList);
    }

    @GetMapping("/findChoiceQuestionsByExamination_Id")
    @ApiOperation(value = "根据考试id查询该次考试所有试题",notes = "findByExamination_Id")
    @WebLog(description = "findChoiceQuestionsByExamination_Id")
    public CommonResult<List<ChoiceQuestion>> findChoiceQuestionsByExamination_Id(@RequestParam Integer id){
        List<ChoiceQuestion> choiceQuestions = choiceQuestionService.findChoiceQuestionsByExamination_id(id);
        return new CommonResult<List<ChoiceQuestion>>(ResultEnum.SUCCESS.getCode(),"findChoiceQuestionsByExamination_Id",choiceQuestions);
    }
}
