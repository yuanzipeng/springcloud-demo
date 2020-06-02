package com.springcloud.demo.user.controller;

import com.springcloud.demo.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yzp
 * @Date: 2020-6-2 10:19
 * @description
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块",description = "UserController")
public class UserController {

    @GetMapping("test")
    public Result test(){
        return Result.success();
    }
}
