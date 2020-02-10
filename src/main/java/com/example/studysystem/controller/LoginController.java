package com.example.studysystem.controller;

import com.example.studysystem.DTO.UserDto;
import com.example.studysystem.entity.CommonResult;
import com.example.studysystem.entity.Teacher;
import com.example.studysystem.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Misaikun
 * @ClassName LoginController
 * @description
 * @date 2020/2/2 21:51
 */
@RequestMapping( "/login")
@Api(value = "登录控制类")
@RestController
public class LoginController {

    @Autowired
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();

    @ApiOperation(value = "教师登录",notes = "根据用户名、密码判断该用户是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public CommonResult login( UserDto userDto) {//@RequestBody
        System.out.println(userDto.getName());
        Teacher teacher = teacherService.findByName(userDto.getName());
        if (userDto.getPassword().equals(teacher.getPassword()))
            return CommonResult.success(userDto.getName());
        else
            return CommonResult.validateFailed();
    }
}