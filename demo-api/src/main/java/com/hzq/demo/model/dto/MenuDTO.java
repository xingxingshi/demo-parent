package com.hzq.demo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MenuDTO implements Serializable {

    /**
     */
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 跳转url
     */
    private String url;

    /**
     * 小图标
     */
    private String minIcon;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单自动生成code
     */
    private String code;

    /**
     * 菜单自动生成pcode
     */
    private String parentCode;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否是新功能
     */
    private Integer isNew;

    /**
     * 是否可点击
     */
    private Integer isEnter;

    /**
     * 菜单所属项目
     */
    private String platform;

    /**
     * 调用来源
     */
    private Integer invokeSource;

    /**
     * 操作的用户id
     */
    private Integer optUserId;

    /**
     * 是否展示快捷菜单，0否，1是
     */
    private Integer isShortcutDisplay;

    /**
     * 是否生效
     */
    private Integer isValid;
}
