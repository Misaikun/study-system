package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.Knowledge;
import com.example.studysystem.entity.ResultEnum;
import com.example.studysystem.service.impl.KnowledgeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author Misaikun
 * @ClassName KnowledgeController
 * @description
 * @date 2020/3/9 22:00
 */

@RequestMapping( "/Knowledge")
@Api(value = "知识点控制类")
@RestController
public class KnowledgeController {
    @Autowired
    private KnowledgeServiceImpl knowledgeService;

    @GetMapping("/findByPage")
    @ApiOperation(value="分页查询所有知识点")
    @WebLog(description = "分页查询所有知识点")
    public CommonResult<Page<Knowledge>> findByPage(@RequestParam  Integer page){
        if(page==0)
            page=1;
        Page<Knowledge> knowledgePage =  knowledgeService.findByPage(page-1,2);
        return new CommonResult<Page<Knowledge>>(ResultEnum.SUCCESS.getCode(),"findByPage",knowledgePage);
    }
    @PostMapping("/save")
    @ApiOperation(value="保存知识点")
    @WebLog(description = "保存知识点")
    public CommonResult<Knowledge> save(@RequestBody Knowledge knowledge){
        Knowledge knowledge1 = knowledgeService.save(knowledge);
        return new CommonResult<Knowledge>(ResultEnum.SUCCESS.getCode(),"save",knowledge1);
    }

    @PostMapping("/update")
    @ApiOperation(value="更新知识点")
    @WebLog(description = "更新知识点")
    public CommonResult<Knowledge> update(@RequestBody Knowledge knowledge){
        Knowledge knowledge1 =  knowledgeService.update(knowledge);
        return new CommonResult<Knowledge>(ResultEnum.SUCCESS.getCode(),"update",knowledge1);
    }


    @GetMapping("/delete")
    @ApiOperation(value="删除知识点")
    @WebLog(description = "删除知识点")
    public CommonResult<Integer> delete(@RequestParam Integer id){
        knowledgeService.delete(id);
        return new CommonResult<Integer>(ResultEnum.SUCCESS.getCode(),"delete",id);
    }

}
