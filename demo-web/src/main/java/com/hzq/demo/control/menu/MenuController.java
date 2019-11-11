package com.hzq.demo.control.menu;

import com.hzq.demo.service.menu.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
