package com.springcloud.demo.client.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.niws.loadbalancer.NIWSDiscoveryPing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon配置
 *
 * @Author: yzp
 * @Date: 2020-6-5 9:33
 * @description
 */
@Configuration
public class RibbonConfig {

    /**
     * @return 负载均衡规则
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

    /**
     * IPing算法规则，不执行Ping操作，
     * 根据Eureka Clien反馈判断存活
     *
     * @return
     */
    @Bean
    public IPing iPing() {
        return new NIWSDiscoveryPing();
    }

}
