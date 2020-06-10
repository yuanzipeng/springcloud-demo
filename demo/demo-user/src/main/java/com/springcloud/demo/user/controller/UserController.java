package com.springcloud.demo.user.controller;

import com.springcloud.demo.api.user.entity.User;
import com.springcloud.demo.common.utils.JwtTokenUtil;
import com.springcloud.demo.user.mapper.UserMapper;
import com.springcloud.demo.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private UserMapper userMapper;

    @Value("${server.port}")
    private int port;


    @GetMapping("test")
    @ApiOperation(value = "Result测试接口")
    public Result<String> test(String msg) {

        return Result.success(msg+port);
    }

    @GetMapping("tests")
    @ApiOperation(value = "String测试接口")
    public String tests(String msg) {
        return msg;
    }

    @PostMapping("login")
    @ApiOperation(value = "登录接口")
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

    @GetMapping("getUserList")
    @ApiOperation(value = "获取用户信息列表")
    public Result<Map<String,Object>> getUserList() {
        List<User> userList = userMapper.selectList(null);
        Map<String,Object> map = new HashMap<>();
        map.put("port",port);
        map.put("userList",userList);
        return Result.success(map);
    }

    @PostMapping("getUser")
    @ApiOperation(value = "获取用户信息")
    public Result<Map<String,Object>> getUser(@RequestBody User user) {
        User user1 = userMapper.selectById(user.getUuid());
        Map<String,Object> map = new HashMap<>();
        map.put("port",port);
        map.put("user1",user1);
        return Result.success(map);
    }

}
