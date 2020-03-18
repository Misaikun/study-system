package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
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
    public Page<Score> findByPage(@RequestParam Integer page, @RequestParam Integer size){
        if(page==0)
            page=1;
        return scoreService.findByPage(page-1,size);
    }

    @PostMapping("/save")
    @ApiOperation(value="保存分数")
    @WebLog(description = "保存分数")
    public Score save(@RequestBody Score score){
        return scoreService.save(score);
    }


    @PostMapping("/update")
    @ApiOperation(value="更新分数")
    @WebLog(description = "更新分数")
    public Score update(@RequestBody Score score){
        return scoreService.update(score);
    }


    @GetMapping("/delete")
    @ApiOperation(value="删除分数")
    @WebLog(description = "删除分数")
    public void delete(@RequestParam Integer id){
        scoreService.delete(id);
    }


    @GetMapping("/findByExamination_Id")
    @ApiOperation(value="查找某场考试所有人成绩")
    @WebLog(description = "通过Examination_Id查询分数")
    public List<Score> findByExamination_Id(@RequestParam Integer id){
        return scoreService.findByExamination_Id(id);
    }

    @GetMapping("/findByStudent_Id")
    @ApiOperation(value="查找某人所有考试成绩")
    @WebLog(description = "通过Student_Id查询分数")
    public List<Score> findByStudent_Id(@RequestParam Integer id){
        return scoreService.findByStudent_Id(id);
    }

    @GetMapping("/findByStudent_IdAndAndExamination_Id")
    @ApiOperation(value="查找某人某场考试成绩")
    @WebLog(description = "通过Student_Id和Examination_Id查询分数")
    public List<Score> findByStudent_IdAndAndExamination_Id(@RequestParam Integer sid,@RequestParam Integer eid){
        return scoreService.findByStudent_IdAndAndExamination_Id(sid,eid);
    }
}
