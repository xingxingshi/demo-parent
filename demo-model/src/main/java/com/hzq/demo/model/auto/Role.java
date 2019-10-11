package com.hzq.demo.model.auto;

import lombok.Data;

import java.util.Date;

/**
 * 角色表
 * demo_role
 */
@Data
public class Role {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 操作用户id
     */
    private Integer optUserId;

    /**
     * 角色类型：管理员角色 ADMIN 默认集团角色模板:DEFAULT_SHOP：默认店铺角色模板:DEFAULT_STORE,自定义集团角色模板:	CUSTOM_SHOP,自定义店铺角色模板:	CUSTOM_STORE;角色类型  默认商家(唯一），默认店铺（唯一），自定义商家，自定义店铺
     */
    private String roleType;

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

    /**
     * 备注
     */
    private String remark;
}