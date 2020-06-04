package com.springcloud.demo.client.controller;

import com.springcloud.demo.client.entity.User;
import com.springcloud.demo.client.feign.UseFeign;
import com.springcloud.demo.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yzp
 * @Date: 2020-6-4 10:59
 * @description
 */
@Slf4j
@RestController
@RequestMapping("consumer")
@Api(tags = "服务调用演示",description = "ConsumerController")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UseFeign useFeign;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("hello")
    @ApiOperation(value = "原始版服务调用演示")
    public String hello(String msg){
        //原始版服务调用演示
        /*String hostName = "localhost";
        int port = 8083;
        String uri = "/user/user/test?msg="+msg;
        String url = "http://"+hostName+":"+port+uri;*/
        ServiceInstance chooser = loadBalancerClient.choose("demo-user");
        String hostName = chooser.getHost();
        int port = chooser.getPort();
        String uri = "/user/user/test?msg="+msg;
        String url = "http://"+hostName+":"+port+uri;
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }

    @GetMapping("feign")
    @ApiOperation(value = "feign测试接口")
    public Result<String> feign(String msg){
        log.info("feign"+msg);
        //feign调用演示
        Result<String> result = useFeign.test(msg);
        return result;
    }

    @GetMapping("feigns")
    @ApiOperation(value = "feigns测试接口")
    public String feigns(String msg){
        log.info("feigns"+msg);
        //feign调用演示
        String result = useFeign.tests(msg);
        return result;
    }

    @GetMapping("getUserList")
    @ApiOperation(value = "获取用户信息列表")
    public Result<List<User>> getUserList(){
        log.info("getUserList获取用户信息列表");
        //feign调用演示
        Result<List<User>> result = useFeign.getUserList();
        List<User> users= result.getData();
        log.info("getUserList获取用户信息列表:{}",users);
        return result;
    }

    @PostMapping("getUser")
    @ApiOperation(value = "获取用户信息")
    public Result<User> getUser(@RequestBody User user){
        log.info("getUser获取用户信息"+user);
        //feign调用演示
        Result<User> result = useFeign.getUser(user);
        return result;
    }
}
