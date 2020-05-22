package com.springcloud.demo.common;

import com.springcloud.demo.common.entity.User;
import com.springcloud.demo.common.mapper.UserMapper;
import com.springcloud.demo.common.result.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@SpringBootApplication
public class DemoCommonApplication {

    @Resource
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoCommonApplication.class, args);
    }

    @GetMapping("")
    public Result test(){
        List<User> list = userMapper.selectList(null);
        return Result.success(list);
    }

}
