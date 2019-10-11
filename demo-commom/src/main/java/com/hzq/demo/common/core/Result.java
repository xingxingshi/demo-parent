package com.hzq.demo.common.core;

import com.hzq.demo.common.enums.ResultStateEnum;

/**
 * @author HZQ
 * @description web层返回的通用格式
 * @Date: 2019-05-31
 * @Time: 14:25
 */
public class Result<T> {

    /**
     * 执行状态
     */
    private boolean success = false;

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回值
     */
    private T data = null;

    /**
     * 返回信息
     */
    private String msg = "";

    public Result() {

    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<T>();
        r.setData(data);
        r.setSuccess(true);
        r.setCode(ResultStateEnum.SUCCESS.getCode());
        r.setMsg(ResultStateEnum.SUCCESS.getMessage());
        return r;
    }

    public static <T> Result<T> fail(ResultStateEnum resultCodeEnum, String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(resultCodeEnum.getCode());
        r.setMsg(msg);
        return r;
    }



    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }


    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public String getCode() {
        return code;
    }
    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }
}

