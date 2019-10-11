package com.hzq.demo.dao.auto;

import com.hzq.demo.model.auto.UserRelRole;

public interface UserRelRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRelRole record);

    int insertSelective(UserRelRole record);

    UserRelRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRelRole record);

    int updateByPrimaryKey(UserRelRole record);
}