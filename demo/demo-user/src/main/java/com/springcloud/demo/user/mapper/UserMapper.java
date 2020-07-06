package com.springcloud.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.api.user.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yuanzp
 * @since 2020-05-22
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> queryList();
}
