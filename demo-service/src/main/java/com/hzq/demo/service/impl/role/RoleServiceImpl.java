package com.hzq.demo.service.impl.role;

import com.hzq.demo.dao.ext.RoleExtMapper;
import com.hzq.demo.dao.ext.RoleRelMenuExtMapper;
import com.hzq.demo.dao.ext.RoleRelWidgetExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
