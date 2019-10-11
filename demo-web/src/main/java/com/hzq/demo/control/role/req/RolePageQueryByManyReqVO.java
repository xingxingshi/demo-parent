package com.hzq.demo.control.role.req;

import com.hzq.demo.common.core.PageReqBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 14:30
 */
@Data
@ApiModel("分页查询角色请求参数")
public class RolePageQueryByManyReqVO extends PageReqBase {

    @ApiModelProperty("角色名")
    private String name;

    @ApiModelProperty("角色类型")
    private String roleType;

    @ApiModelProperty("是否可用")
    private Integer isValid;
}
