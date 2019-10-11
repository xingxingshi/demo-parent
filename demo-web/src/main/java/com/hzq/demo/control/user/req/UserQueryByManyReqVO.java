package com.hzq.demo.control.user.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "查询用户信息请求参数")
public class UserQueryByManyReqVO {


    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "是否可用")
    private Integer isValid;
}