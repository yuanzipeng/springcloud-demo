package com.springcloud.demo.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EurekaApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("***启动成功***访问地址：\thttp://{}:{}",env.getProperty("eureka.instance.hostname"),env.getProperty("server.port"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> log.info("启动shutdownHook对程序进行关闭...")));
    }

}
