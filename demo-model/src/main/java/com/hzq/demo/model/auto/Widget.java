package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 控件表
 * demo_widget
 */
@Data
public class Widget {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 控件名
     */
    private String name;

    /**
     * 控件路径
     */
    private String url;

    /**
     * 控件的编码
     */
    private String controlCode;

    /**
     * 作为唯一code与菜单表关联
     */
    private String menuCode;

    /**
     * 备注
     */
    private String remark;

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
     * 是否可用
     */
    private Integer isValid;
}