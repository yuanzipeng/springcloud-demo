package com.springcloud.demo.client.config;

import com.springcloud.demo.api.user.entity.User;
import com.springcloud.demo.client.feign.UseFeign;
import com.springcloud.demo.utils.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: yzp
 * @Date: 2020-6-9 14:32
 * @description
 */
@Service
public class FeignFallBackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new UseFeign() {
            @Override
            public Result<String> test(String msg) {
                return Result.error("FeignFallBackFactory test"+msg);
            }

            @Override
            public String tests(String msg) {
                return null;
            }

            @Override
            public Result<Map<String, Object>> getUserList() {
                return null;
            }

            @Override
            public Result<Map<String, Object>> getUser(User user) {
                return null;
            }
        };
    }
}
