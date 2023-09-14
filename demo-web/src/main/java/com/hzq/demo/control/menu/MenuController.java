package com.hzq.demo.control.menu;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.control.menu.converter.MenuWebConverter;
import com.hzq.demo.control.menu.vo.AuthMenuVO;
import com.hzq.demo.model.dto.AuthMenuDTO;
import com.hzq.demo.service.menu.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HZQ
 * @description
 * @Date: 2019-05-31
 * @Time: 13:55
 */
@RestController
@Api("菜单相关接口")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/findMenuByUser",method = RequestMethod.GET)
    @ApiOperation(value = "根据角色查找用户",notes = "创建人：黄梓强 20191011")
    public Result<List<AuthMenuVO>> findMenuByUser(){
        List<AuthMenuDTO> authMenu = menuService.findAuthMenu();
        List<AuthMenuVO> authMenuVO = MenuWebConverter.INSTANCE.toAuthMenuVO(authMenu);
        return Result.success(authMenuVO);
    }
}
