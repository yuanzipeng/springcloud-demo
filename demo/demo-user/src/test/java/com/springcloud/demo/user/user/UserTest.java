package com.springcloud.demo.user.user;

import com.springcloud.demo.user.entity.User;
import com.springcloud.demo.user.mapper.UserMapper;
import com.springcloud.demo.user.DemoUserApplicationTests;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yzp
 * @Date: 2020-5-22 11:26
 * @description
 */
public class UserTest extends DemoUserApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void add(){
        User user = new User();
        user.setUserName("test2");
        user.setUserPwd("test2");
        user.setUserPhone("1234562");
        userMapper.insert(user);
    }

    @Test
    public void get(){
        List<User> list = userMapper.selectList(null);
        list.forEach(
                System.out::println
        );
    }

    @Test
    public void update(){
        User user = new User();
        user.setUuid(2);
        user.setUserName("test");
        user.setUserPwd("admin");
        user.setUserPhone("12345678");
        userMapper.updateById(user);

    }

    @Test
    public void delete(){
        userMapper.deleteById(3);
    }

}
