package com.hzq.demo.service.impl.user.req;

import com.hzq.demo.common.core.PageReqBase;
import lombok.Data;

/**
 * @author HZQ
 * @description 多条件查询用户
 * @Date: 2019-05-31
 * @Time: 16:45
 */
@Data
public class UserPageQueryByManyReqDTO extends PageReqBase {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 是否可用
     */
    private Integer isValid;

}
