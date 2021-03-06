package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 用户表
 * demo_user
 */
@Data
public class User {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否记住密码
     */
    private Integer keepPassword;

    /**
     * 是否通过手机认证，0:否，1:是
     */
    private Integer isApprove;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否可用
     */
    private Integer isValid;
}