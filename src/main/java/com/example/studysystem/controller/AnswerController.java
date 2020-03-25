package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.Answer;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.AnswerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName AnswerController
 * @description
 * @date 2020/3/25 9:59
 */
@RestController
@Api(value = "答题控制类")
@RequestMapping("/AnswerController")
public class AnswerController {

    @Autowired
    private AnswerServiceImpl answerService;

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页查询所有答案")
    @WebLog(description = "分页查询所有答案接口")
    public CommonResult<Page<Answer>> findByPage(@RequestParam Integer page) {
        if (page == 0)
            page = 1;
        Page<Answer> answers = answerService.findByPage(page, 2);
        return new CommonResult<Page<Answer>>(ResultEnum.SUCCESS.getCode(),"findByPage",answers);
    }

    @PostMapping("save")
    @ApiOperation(value = "保存一条答题记录")
    @WebLog(description = "保存答题记录接口")
    public CommonResult<Answer> save(@RequestBody Answer answer){
        Answer answer1 = answerService.save(answer);
        return new CommonResult<Answer>(ResultEnum.SUCCESS.getCode(),"save",answer1);
    }

    @PostMapping("uodate")
    @ApiOperation(value = "更新一条答题记录")
    @WebLog(description = "更新答题记录录接口")
    public CommonResult<Answer> uodate(@RequestBody Answer answer){
        Answer answer1 = answerService.update(answer);
        return new CommonResult<Answer>(ResultEnum.SUCCESS.getCode(),"uodate",answer1);
    }

    @GetMapping("delete")
    @ApiOperation(value = "删除一条答题记录")
    @WebLog(description = "删除答题记录录接口")
    public CommonResult<Integer> delete(@RequestParam Integer id){
        answerService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

    @GetMapping("findByStudent_Id")
    @ApiOperation(value = "根据学生id查询答题记录")
    @WebLog(description = "根据学生id查询答题记录录接口")
    public CommonResult<List<Answer>> findByStudent_Id(@RequestParam Integer id){
        List<Answer> answers  = answerService.findByStudent_Id(id);
        return new CommonResult<List<Answer>>(ResultEnum.SUCCESS.getCode(),"findAnswersByChoiceQuestion_Id",answers);
    }

    @GetMapping("findAnswersByExaminationContent_Id")
    @ApiOperation(value = "根据测验内容id查询答题记录")
    @WebLog(description = "根据测验内容id查询答题记录接口")
    public CommonResult<List<Answer>> findAnswersByExaminationContent_Id(@RequestParam Long id){
        List<Answer> answers  = answerService.findAnswersByExaminationContent_Id(id);
        return new CommonResult<List<Answer>>(ResultEnum.SUCCESS.getCode(),"findAnswersByExaminationContent_Id",answers);
    }

    @GetMapping("findAnswersByExamination_IdAndAndStudent_Id")
    @ApiOperation(value = "根据考试id和学生id查询答题记录")
    @WebLog(description = "根据考试id和学生id查询答题记录录接口")
    public CommonResult<List<Answer>> findAnswersByExamination_idAndStudent_id(@RequestParam(name = "examination_id") Integer id1,@RequestParam(name = "student_id") Integer id2){
        List<Answer> answers  = answerService.findAnswersByExamination_idAndStudent_id(id1,id2);
        return new CommonResult<List<Answer>>(ResultEnum.SUCCESS.getCode(),"findAnswersByExamination_idAndStudent_id",answers);
    }

    @GetMapping("COUNTAnswersByExamination_idAndStudent_id")
    @ApiOperation(value = "根据考试id和学生id计算次数")
    @WebLog(description = "根据考试id和学生id计算次数接口")
    public CommonResult<Integer> COUNTAnswersByExamination_idAndStudent_id(@RequestParam(name = "examination_id")Integer id1,@RequestParam(name = "student_id")Integer id2){
        Integer num  = answerService.COUNTAnswersByExamination_idAndStudent_id(id1,id2);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"findAnswersByExamination_ClassInfo_IdAndAndChoiceQuestion_Id",num);
    }
}
