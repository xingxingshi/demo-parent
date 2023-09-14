package com.hzq.demo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthMenuDTO implements Serializable {

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
     * 子节点
     */
    List<AuthMenuDTO> childMenu;
}
