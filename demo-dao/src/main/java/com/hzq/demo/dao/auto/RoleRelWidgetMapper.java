package com.hzq.demo.dao.auto;

import com.hzq.demo.model.auto.RoleRelWidget;

public interface RoleRelWidgetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleRelWidget record);

    int insertSelective(RoleRelWidget record);

    RoleRelWidget selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleRelWidget record);

    int updateByPrimaryKey(RoleRelWidget record);
}