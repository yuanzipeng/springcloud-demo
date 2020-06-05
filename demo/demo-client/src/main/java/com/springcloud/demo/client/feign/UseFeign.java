package com.springcloud.demo.client.feign;

import com.springcloud.demo.client.entity.User;
import com.springcloud.demo.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: yzp
 * @Date: 2020-6-4 10:59
 * @description
 */
@FeignClient(name = "demo-user",path = "/user/user")
public interface UseFeign {

    @GetMapping("test")
    Result<String> test(@RequestParam("msg") String msg);

    @GetMapping("tests")
    String tests(@RequestParam("msg") String msg);

    @GetMapping("getUserList")
    Result<Map<String,Object>> getUserList();

    @PostMapping("getUser")
    Result<Map<String,Object>> getUser(@RequestBody User user);
}
