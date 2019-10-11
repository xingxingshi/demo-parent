package com.hzq.demo.dao.auto;

import com.hzq.demo.model.auto.RoleRelMenu;

public interface RoleRelMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleRelMenu record);

    int insertSelective(RoleRelMenu record);

    RoleRelMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleRelMenu record);

    int updateByPrimaryKey(RoleRelMenu record);
}