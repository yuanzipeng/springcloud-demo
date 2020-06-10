package com.springcloud.demo.utils.result;

/**
 * @Author: yzp
 * @Date: 2020-4-24 9:57
 * @description 返回结果状态码和msg枚举数据封装
 */
public enum Type {

    /*请先登录*/
    LOGIN_REQUIRED("-1", "请先登录"),
    ERROR("9999", "系统异常"),
    SUCCESS("0000", "操作成功!"),
    PERMISSION_DENIED("403", "没有这个权限");

    /**
     *访问结果类型编码
     */
    public String code;
    /**
     * 默认提示信息
     */
    public String defaultMsg;

    Type(String code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }

    public void setDefaultMsg(String defaultMsg) {
        this.defaultMsg = defaultMsg;
    }}
