package com.springcloud.demo.client.feign;

import com.springcloud.demo.client.entity.User;
import com.springcloud.demo.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yzp
 * @Date: 2020-6-4 10:59
 * @description
 */
@FeignClient(name = "userFeign",url = "http://localhost:8100/user/user")
public interface UseFeign {

    @GetMapping("test")
    Result<String> test(@RequestParam("msg") String msg);

    @GetMapping("tests")
    String tests(@RequestParam("msg") String msg);

    @GetMapping("getUserList")
    Result<User> getUserList();

    @PostMapping("getUser")
    Result<User> getUser(@RequestBody User user);
}
