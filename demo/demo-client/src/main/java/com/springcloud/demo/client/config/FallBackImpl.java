package com.springcloud.demo.client.config;

import com.springcloud.demo.client.entity.User;
import com.springcloud.demo.client.feign.UseFeign;
import com.springcloud.demo.common.result.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: yzp
 * @Date: 2020-6-9 14:13
 * @description
 */
@Service
public class FallBackImpl implements UseFeign {


    @Override
    public Result<String> test(String msg) {

        return Result.error("fallback test"+msg);
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
}
