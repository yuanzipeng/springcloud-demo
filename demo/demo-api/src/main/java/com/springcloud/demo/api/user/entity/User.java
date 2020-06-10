package com.springcloud.demo.api.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.springcloud.demo.utils.util.MD5Util;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yuanzp
 * @since 2020-05-22
 */
@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机号
     */
    private String userPhone;

}
