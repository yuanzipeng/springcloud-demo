package com.springcloud.demo.utils.result;

import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yzp
 * @Date: 2020-4-24
 * @description 返回结果封装
 */
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4774033891136934323L;

    /**
     * 结果码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 相关数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long time;

    private Result(Type type) {
        this.code = type.code;
        this.msg = type.defaultMsg;
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Result setTime(long time) {
        this.time = time;
        return this;
    }

    public static Result loginRequired() {
        return new Result(Type.LOGIN_REQUIRED).setTime(System.currentTimeMillis());
    }

    public static Result error() {
        return new Result(Type.ERROR).setTime(System.currentTimeMillis());
    }

    public static Result success() {
        return new Result(Type.SUCCESS).setTime(System.currentTimeMillis());
    }

    public static Result error(String msg) {
        return new Result(Type.ERROR).setMsg(msg).setTime(System.currentTimeMillis());
    }

    public static Result success(Object data) {
        return new Result(Type.SUCCESS).setData(data).setTime(System.currentTimeMillis());
    }

    public static Result permissionDenied() {
        return new Result(Type.PERMISSION_DENIED).setTime(System.currentTimeMillis());
    }

}
