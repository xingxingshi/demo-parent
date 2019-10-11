package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 用户角色表
 * demo_user_rel_role
 */
@Data
public class UserRelRole {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商家中心角色id
     */
    private Integer roleId;

    /**
     * 用户code
     */
    private String roleCode;

    /**
     * 用户类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否有效
     */
    private Integer isValid;
}