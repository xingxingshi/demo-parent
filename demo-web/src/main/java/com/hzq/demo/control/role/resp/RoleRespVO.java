package com.hzq.demo.control.role.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("角色")
public class RoleRespVO {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("角色code")
    private String roleCode;

    @ApiModelProperty("操作用户id")
    private Integer optUserId;

    @ApiModelProperty("角色类型")
    private String roleType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date modifyTime;

    @ApiModelProperty("是否可用")
    private Integer isValid;

    @ApiModelProperty("备注")
    private String remark;
}