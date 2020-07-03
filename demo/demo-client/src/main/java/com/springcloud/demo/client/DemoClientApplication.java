package com.springcloud.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.springcloud.demo")
public class DemoClientApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoClientApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("***启动成功***访问地址：\thttp://localhost:{}{}/swagger-ui.html",env.getProperty("server.port"),env.getProperty("server.servlet.context-path"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> log.info("启动shutdownHook对程序进行关闭...")));
    }

}
