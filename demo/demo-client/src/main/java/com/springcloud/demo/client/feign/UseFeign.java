package com.springcloud.demo.client.feign;

import com.springcloud.demo.api.user.feign.UseFeigns;
import com.springcloud.demo.client.config.FeignFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: yzp
 * @Date: 2020-6-4 10:59
 * @description
 */
@FeignClient(name = "demo-user",
        path = "/user/user",
        //fallback = FallBackImpl.class
        fallbackFactory = FeignFallBackFactory.class
)
public interface UseFeign extends UseFeigns {

}
