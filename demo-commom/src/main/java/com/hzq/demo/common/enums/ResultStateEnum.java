package com.hzq.demo.common.enums;

/**
 * @author HZQ
 * @description 返回状态的公共枚举
 * @Date: 2019-05-31
 * @Time: 14:28
 */
public enum ResultStateEnum {

    SUCCESS("200","成功","请求成功"),

    FAIL("500","失败","服务器繁忙，请稍后再试")

    ;

    private String code;

    private String status;

    private String message;

    ResultStateEnum(String code, String status,String message){
        this.code=code;
        this.status=status;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
