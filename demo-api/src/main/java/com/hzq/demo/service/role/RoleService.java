package com.hzq.demo.service.role;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.service.role.req.RoleSaveReqDTO;

/**
 * @Author HZQ
 * @Version  1.0
 * @Description 角色服务
 * @Date 2019-10-11
 * @Time 14:51
 */
public interface RoleService {

    /**
     * 保存角色
     * @param roleSaveReqDTO
     * @return
     */
    Result<Boolean> saveRole(RoleSaveReqDTO roleSaveReqDTO);
}
