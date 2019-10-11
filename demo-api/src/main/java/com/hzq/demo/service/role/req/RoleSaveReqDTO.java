package com.hzq.demo.service.role.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author HZQ
 * @Version  1.0
 * @Description  保存角色对象
 * @Date 2019-10-11
 * @Time 14:36
 */
@Data
public class RoleSaveReqDTO {


    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("角色code")
    private String roleCode;

    @ApiModelProperty("操作用户id")
    private Integer optUserId;

    @ApiModelProperty("角色类型：管理员角色 ADMIN 默认集团角色模板:DEFAULT_SHOP：默认店铺角色模板:DEFAULT_STORE,自定义集团角色模板:\tCUSTOM_SHOP,自定义店铺角色模板:\tCUSTOM_STORE;角色类型  默认商家(唯一），默认店铺（唯一），自定义商家，自定义店铺\n")
    private String roleType;

    @ApiModelProperty("是否可用")
    private Integer isValid;

    @ApiModelProperty("备注")
    private String remark;
}