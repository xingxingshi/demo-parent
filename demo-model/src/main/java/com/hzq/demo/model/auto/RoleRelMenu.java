package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 角色菜单表
 * demo_role_rel_menu
 */
@Data
public class RoleRelMenu {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 操作者id
     */
    private Integer optUserId;

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