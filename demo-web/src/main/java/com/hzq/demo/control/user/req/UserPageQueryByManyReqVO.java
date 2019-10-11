package com.hzq.demo.control.user.req;

import com.hzq.demo.common.core.PageReqBase;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-03
 * @Time: 09:59
 */
@Data
public class UserPageQueryByManyReqVO extends PageReqBase {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "是否可用")
    private Integer isValid;


}
