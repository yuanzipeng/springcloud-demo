package com.springcloud.demo.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateCofig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
