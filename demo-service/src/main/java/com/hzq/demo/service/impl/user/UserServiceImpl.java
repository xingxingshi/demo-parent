package com.hzq.demo.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzq.demo.annotations.SysLog;
import com.hzq.demo.common.core.PageResult;
import com.hzq.demo.common.util.ConverUtils;
import com.hzq.demo.dao.ext.UserExtMapper;
import com.hzq.demo.model.auto.User;
import com.hzq.demo.model.ext.user.req.UserQueryByManyReqExt;
import com.hzq.demo.service.user.UserService;
import com.hzq.demo.service.user.req.UserPageQueryByManyReqDTO;
import com.hzq.demo.service.user.req.UserQueryByManyReqDTO;
import com.hzq.demo.service.user.resp.UserRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoqiang
 * @version $$Id: UserServiceImpl.java, v 0.1 2019/4/19 16:43 xiaoqiang Exp $$
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserExtMapper userExtMapper;

    @SysLog
    @Override
    public UserRespDTO findUserById(Integer id) {
        User user = userExtMapper.selectByPrimaryKey(id);
        UserRespDTO userRespDTO = ConverUtils.converOne(user, UserRespDTO.class);
        return userRespDTO;
    }

    @Override
    public List<UserRespDTO> findUserByMany(UserQueryByManyReqDTO reqDTO) {
        UserQueryByManyReqExt reqExt = ConverUtils.converOne(reqDTO, UserQueryByManyReqExt.class);
        List<User> users = userExtMapper.selectUserByMany(reqExt);
        return ConverUtils.converList(users,UserRespDTO.class);
    }

    @Override
    public PageResult<UserRespDTO> findPageUserByMany(UserPageQueryByManyReqDTO reqDTO) {
        PageResult<UserRespDTO> result=new PageResult<>();
        UserQueryByManyReqExt reqExt = ConverUtils.converOne(reqDTO, UserQueryByManyReqExt.class);
        PageHelper.startPage(reqDTO.getPageNumber(), reqDTO.getPageSize());
        List<User> users = userExtMapper.selectUserByMany(reqExt);
        PageInfo<User> userPageInfo=new PageInfo<>(users,reqDTO.getPageSize());
        result.setDate(ConverUtils.converList(userPageInfo.getList(),UserRespDTO.class));
        result.setPageNumber(userPageInfo.getPageNum());
        result.setPageSize(userPageInfo.getPageSize());
        result.setTotal(userPageInfo.getTotal());
        result.setPages(userPageInfo.getPages());
        return result;
    }
}
