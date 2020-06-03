package com.springcloud.demo.client.controller;

import com.springcloud.demo.common.result.Result;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("hello")
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
}
