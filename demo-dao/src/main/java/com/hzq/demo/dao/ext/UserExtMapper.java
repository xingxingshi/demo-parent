package com.hzq.demo.dao.ext;

import com.hzq.demo.dao.auto.UserMapper;
import com.hzq.demo.model.auto.User;
import com.hzq.demo.model.ext.user.req.UserQueryByManyReqExt;

import java.util.List;

public interface UserExtMapper extends UserMapper {

    /**
     * 多条件查询用户信息
     * @param reqExt
     * @return
     */
    List<User> selectUserByMany(UserQueryByManyReqExt reqExt);

}