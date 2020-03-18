package com.example.studysystem.controller;

import com.example.studysystem.aspect.webLog.WebLog;
import com.example.studysystem.entity.Message;
import com.example.studysystem.service.impl.MessageServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName MessageController
 * @description 控制消息
 * @date 2020/3/17 20:58
 */

@RequestMapping( "/Message")
@Api(value = "消息控制类")
@RestController
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping("/findByPage")
    @ApiOperation(value="分页查询所有消息")
    @WebLog(description = "分页查询所有消息")
    public Page<Message> findByPage(@RequestParam Integer page){
        if(page==0)
            page=1;
        return messageService.findByPage(page-1,2);
    }

    @PostMapping("/update")
    @ApiOperation(value="更改消息")
    @WebLog(description = "对消息进行更改")
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @PostMapping("/save")
    @ApiOperation(value="保存消息")
    @WebLog(description = "建立一个新的消息")
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }

    @GetMapping("/delete")
    @ApiOperation(value="删除消息")
    @WebLog(description = "删除消息")
    public void delete(@RequestParam Integer id){
        messageService.delete(id);
    }

    @GetMapping("/findByClassInfo_Id")
    @ApiOperation(value="根据班级id查询班级消息")
    @WebLog(description = "根据班级id查询班级消息")
    public List<Message> findByClassInfo_Id(@RequestParam Integer id){
        return messageService.findByClassInfo_Id(id);
    }
}
