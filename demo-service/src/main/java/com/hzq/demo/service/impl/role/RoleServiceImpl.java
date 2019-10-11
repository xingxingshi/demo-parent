package com.hzq.demo.service.impl.role;

import com.hzq.demo.annotations.SysLog;
import com.hzq.demo.common.core.Result;
import com.hzq.demo.common.util.ConverUtils;
import com.hzq.demo.dao.ext.RoleExtMapper;
import com.hzq.demo.dao.ext.RoleRelMenuExtMapper;
import com.hzq.demo.dao.ext.RoleRelWidgetExtMapper;
import com.hzq.demo.model.auto.Role;
import com.hzq.demo.service.role.RoleService;
import com.hzq.demo.service.role.req.RoleSaveReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 09:24
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleExtMapper roleExtMapper;

    @Autowired
    private RoleRelMenuExtMapper roleRelMenuExtMapper;

    @Autowired
    private RoleRelWidgetExtMapper roleRelWidgetExtMapper;

    @SysLog
    @Override
    public Result<Boolean> saveRole(RoleSaveReqDTO roleSaveReqDTO) {
        Role role= ConverUtils.converOne(roleSaveReqDTO,Role.class);
        role.setCreateTime(new Date());
        role.setModifyTime(new Date());
        roleExtMapper.insert(role);
        return Result.success(true);
    }
}
