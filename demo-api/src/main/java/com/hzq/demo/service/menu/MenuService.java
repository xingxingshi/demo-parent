package com.hzq.demo.service.menu;

import com.hzq.demo.model.dto.AuthMenuDTO;

import java.util.List;

/**
 * @author HZQ
 * @description
 * @Date: 2019-05-31
 * @Time: 13:53
 */
public interface MenuService {

    /**
     * 登录查询所有菜单
     * @return
     */
    List<AuthMenuDTO> findAuthMenu();
}
