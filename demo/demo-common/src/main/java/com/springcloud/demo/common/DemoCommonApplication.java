package com.springcloud.demo.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.common.mapper.UserMapper;
import com.springcloud.demo.common.result.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        Page page = new Page(1,10);
        IPage iPage = userMapper.selectPage(page,null);
        return Result.success(iPage);
    }

}
