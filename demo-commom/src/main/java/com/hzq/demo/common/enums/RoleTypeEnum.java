package com.hzq.demo.common.enums;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 14:32
 */
public enum RoleTypeEnum {

    ADMIN("ADMIN","管理员");

    private String code;

    private String message;


    RoleTypeEnum(String code,String message){
        this.code=code;
        this.message=message;
    }
}
