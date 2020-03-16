package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.ChoiceQuestion;
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
    public Page<ChoiceQuestion> findByPage(@RequestParam Integer page) {
        if (page == 0)
            page = 1;
        return choiceQuestionService.findByPage(page, 2);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存选择题")
    @WebLog(description = "保存选择题接口")
    public ChoiceQuestion save(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.save(choiceQuestion);
    }


    @PutMapping("/update")
    @ApiOperation(value = "更新选择题")
    @WebLog(description = "更新选择题接口")
    public ChoiceQuestion update(@RequestBody ChoiceQuestion choiceQuestion) {
        return choiceQuestionService.update(choiceQuestion);
    }


    @GetMapping("/delete")
    @ApiOperation(value = "删除选择题")
    @WebLog(description = "删除选择题接口")
    public void delete(@RequestParam Integer id) {
        choiceQuestionService.delete(id);
    }

    @GetMapping("/findAllByKnowledge_Name")
    @ApiOperation(value = "根据知识点名字查询")
    @WebLog(description = "根据知识点名字查询")
    public List<ChoiceQuestion> findAllByKnowledge_Name(@RequestParam String name) {
        return choiceQuestionService.findAllByKnowledge_Name(name);
    }

}
