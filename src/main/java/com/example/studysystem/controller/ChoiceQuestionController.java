package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.ChoiceQuestion;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.ChoiceQuestionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName ChoiceQuestionController
 * @description
 * @date 2020/3/9 11:10
 */

@RestController
@Api(value = "选择题控制类")
@RequestMapping("/ChoiceQuestionController")
public class ChoiceQuestionController {

    @Autowired
    ChoiceQuestionServiceImpl choiceQuestionService;

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有选择题")
    @WebLog(description = "分页查询所有选择题接口")
    public CommonResult<Page<ChoiceQuestion>> findByPage(@RequestParam Integer page) {
        if (page == 0)
            page = 1;
        Page<ChoiceQuestion> choiceQuestions = choiceQuestionService.findByPage(page, 2);
        return new CommonResult<Page<ChoiceQuestion>>(ResultEnum.SUCCESS.getCode(),"findByPage",choiceQuestions);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存选择题")
    @WebLog(description = "保存选择题接口")
    public CommonResult<ChoiceQuestion> save(@RequestBody ChoiceQuestion choiceQuestion) {
        ChoiceQuestion choiceQuestion1 = choiceQuestionService.save(choiceQuestion);
        return new CommonResult<ChoiceQuestion>(ResultEnum.SUCCESS.getCode(),"save",choiceQuestion1);
    }


    @PutMapping("/update")
    @ApiOperation(value = "更新选择题")
    @WebLog(description = "更新选择题接口")
    public CommonResult<ChoiceQuestion> update(@RequestBody ChoiceQuestion choiceQuestion) {
        ChoiceQuestion choiceQuestion1 = choiceQuestionService.update(choiceQuestion);
        return new CommonResult<ChoiceQuestion>(ResultEnum.SUCCESS.getCode(),"update",choiceQuestion1);
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除选择题")
    @WebLog(description = "删除选择题接口")
    public CommonResult<Integer> delete(@RequestParam Integer id) {
        choiceQuestionService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

    @GetMapping("/findAllByKnowledge_Name")
    @ApiOperation(value = "根据知识点名字查询")
    @WebLog(description = "根据知识点名字查询")
    public CommonResult<List<ChoiceQuestion>> findAllByKnowledge_Name(@RequestParam String name) {
        List<ChoiceQuestion> choiceQuestions = choiceQuestionService.findAllByKnowledge_Name(name);
        return new CommonResult<List<ChoiceQuestion>>(ResultEnum.SUCCESS.getCode(),"findAllByKnowledge_Name",choiceQuestions);
    }

}
