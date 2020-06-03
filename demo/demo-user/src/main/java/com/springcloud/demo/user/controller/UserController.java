package com.springcloud.demo.user.controller;

import com.springcloud.demo.common.result.Result;
import com.springcloud.demo.common.utils.JwtTokenUtil;
import com.springcloud.demo.user.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yzp
 * @Date: 2020-6-2 10:19
 * @description
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块", description = "UserController")
public class UserController {

    @GetMapping("test")
    public Result test() {
        return Result.success();
    }

    @PostMapping("login")
    public Result login(@RequestBody User user) {

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        //用户名加盐生成token
        String token = jwtTokenUtil.generateToken(user.getUserName(), randomKey);
        Map<String, String> map = new HashMap<>();
        map.put("randomKey", randomKey);
        map.put("token", token);
        return Result.success(map);
    }
}
