package com.hzq.demo.service.impl.user;

import com.hzq.demo.common.core.PageResult;
import com.hzq.demo.service.impl.user.req.UserPageQueryByManyReqDTO;
import com.hzq.demo.service.impl.user.req.UserQueryByManyReqDTO;
import com.hzq.demo.service.impl.user.resp.UserRespDTO;

import java.util.List;

/**
 * @author xiaoqiang
 * @version $$Id: UserService.java, v 0.1 2019/4/19 16:41 xiaoqiang Exp $$
 */
public interface UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UserRespDTO findUserById(Integer id);

    /**
     * 多条件查询用户信息
     * @param reqDTO
     * @return
     */
    List<UserRespDTO> findUserByMany(UserQueryByManyReqDTO reqDTO);

    /**
     * 分页查询用户信息
     * @param reqDTO
     * @return
     */
    PageResult<UserRespDTO> findPageUserByMany(UserPageQueryByManyReqDTO reqDTO);
}
