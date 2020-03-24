package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.entity.Score;
import com.example.studysystem.service.impl.ScoreServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName ScoreController
 * @description
 * @date 2020/3/17 22:41
 */


@RequestMapping( "/Score")
@Api(value = "分数控制类")
@RestController
public class ScoreController {
    @Autowired
    private ScoreServiceImpl scoreService;

    @GetMapping("/findByPage")
    @ApiOperation(value="分页查询所有分数")
    @WebLog(description = "分页查询所有分数")
    public CommonResult<Page<Score>> findByPage(@RequestParam Integer page, @RequestParam Integer size){
        if(page==0)
            page=1;
        Page<Score> scorePage = scoreService.findByPage(page-1,size);
        return new CommonResult<Page<Score>>(ResultEnum.SUCCESS.getCode(),"findByPage",scorePage);
    }

    @PostMapping("/save")
    @ApiOperation(value="保存分数")
    @WebLog(description = "保存分数")
    public CommonResult<Score> save(@RequestBody Score score){
        Score score1 = scoreService.save(score);
        return new CommonResult<Score>(ResultEnum.SUCCESS.getCode(),"save",score1);
    }


    @PostMapping("/update")
    @ApiOperation(value="更新分数")
    @WebLog(description = "更新分数")
    public CommonResult<Score> update(@RequestBody Score score){
        Score score1 = scoreService.update(score);
        return new CommonResult<Score>(ResultEnum.SUCCESS.getCode(),"update",score1);
    }


    @GetMapping("/delete")
    @ApiOperation(value="删除分数")
    @WebLog(description = "删除分数")
    public CommonResult<Integer> delete(@RequestParam Integer id){
        scoreService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }


    @GetMapping("/findByExamination_Id")
    @ApiOperation(value="查找某场考试所有人成绩")
    @WebLog(description = "通过Examination_Id查询分数")
    public CommonResult<List<Score>> findByExamination_Id(@RequestParam Integer id){
        List<Score> scoreList = scoreService.findByExamination_Id(id);
        return new CommonResult<List<Score>>(ResultEnum.SUCCESS.getCode(),"findByExamination_Id",scoreList);
    }

    @GetMapping("/findByStudent_Id")
    @ApiOperation(value="查找某人所有考试成绩")
    @WebLog(description = "通过Student_Id查询分数")
    public CommonResult<List<Score>> findByStudent_Id(@RequestParam Integer id){
        List<Score> scoreList = scoreService.findByStudent_Id(id);
        return new CommonResult<List<Score>>(ResultEnum.SUCCESS.getCode(),"findByStudent_Id",scoreList);
    }

    @GetMapping("/findByStudent_IdAndAndExamination_Id")
    @ApiOperation(value="查找某人某场考试成绩")
    @WebLog(description = "通过Student_Id和Examination_Id查询分数")
    public CommonResult<List<Score>> findByStudent_IdAndAndExamination_Id(@RequestParam Integer sid,@RequestParam Integer eid){
        List<Score> scoreList = scoreService.findByStudent_IdAndAndExamination_Id(sid,eid);
        return new CommonResult<List<Score>>(ResultEnum.SUCCESS.getCode(),"findByStudent_IdAndAndExamination_Id",scoreList);
    }
}
