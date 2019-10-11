package com.hzq.demo.service.impl.menu;

import com.hzq.demo.dao.ext.MenuExtMapper;
import com.hzq.demo.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-03
 * @Time: 18:44
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuExtMapper menuExtMapper;

}
