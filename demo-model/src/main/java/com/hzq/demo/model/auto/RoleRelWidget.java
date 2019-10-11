package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 角色控件表表
 * demo_role_rel_widget
 */
@Data
public class RoleRelWidget {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 控件的code
     */
    private String widgetCode;

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