package com.hzq.demo.control.role;

import com.hzq.demo.common.core.PageResult;
import com.hzq.demo.common.core.Result;
import com.hzq.demo.control.role.resp.RoleRespVO;
import com.hzq.demo.service.role.RoleService;
import com.hzq.demo.service.role.req.RoleSaveReqDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 09:32
 */
@Api("角色相关")
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @ApiOperation(value = "保存角色",notes = "创建人：黄梓强 20191011")
    public Result<Boolean> saveRole(@RequestBody RoleSaveReqDTO roleSaveReqDTO){
        return roleService.saveRole(roleSaveReqDTO);
    }

    @RequestMapping(value = "/findRolePageByMany",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询角色信息",notes = "创建人：黄梓强 20190604")
    public Result<PageResult<RoleRespVO>> findRolePageByMany(){
        return Result.success(null);
    }
}
