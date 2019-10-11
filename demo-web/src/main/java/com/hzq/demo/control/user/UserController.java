package com.hzq.demo.control.user;

import com.hzq.demo.common.core.PageResult;
import com.hzq.demo.common.core.Result;
import com.hzq.demo.common.util.ConverUtils;
import com.hzq.demo.control.user.req.UserPageQueryByManyReqVO;
import com.hzq.demo.control.user.req.UserQueryByManyReqVO;
import com.hzq.demo.control.user.resp.UserRespVO;
import com.hzq.demo.service.user.UserService;
import com.hzq.demo.service.user.req.UserPageQueryByManyReqDTO;
import com.hzq.demo.service.user.req.UserQueryByManyReqDTO;
import com.hzq.demo.service.user.resp.UserRespDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author xiaoqiang
 * @version $$Id: UserController.java, v 0.1 2019/4/19 16:47 xiaoqiang Exp $$
 */
@RestController
@RequestMapping("user")
@Api("用户相关接口信息")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    @ApiOperation(value = "通过id查找用户信息", notes = "创建人：黄梓强 \n 创建时间 2019.5.30")
    public Result<UserRespVO> findUserById(@RequestParam @ApiParam(value = "用户id", required = true) Integer id) {
        UserRespDTO userRespDTO = userService.findUserById(id);
        UserRespVO userRespVO = ConverUtils.converOne(userRespDTO, UserRespVO.class);
        return Result.success(userRespVO);
    }

    @RequestMapping(value = "/findUserByMany", method = RequestMethod.POST)
    @ApiOperation(value = "多条件查询用户信息", notes = "创建人：黄梓强 /n 创建时间 2019.5.31")
    public Result<List<UserRespVO>> findUserByMany(@RequestBody UserQueryByManyReqVO reqVO) {
        UserQueryByManyReqDTO reqDTO=ConverUtils.converOne(reqVO,UserQueryByManyReqDTO.class);
        List<UserRespDTO> userRespDTOS = userService.findUserByMany(reqDTO);
        return Result.success(ConverUtils.converList(userRespDTOS,UserRespVO.class));
    }

    @RequestMapping(value = "/findPageUserByMany", method = RequestMethod.POST)
    @ApiOperation(value = "多条件分页查询用户信息", notes = "创建人：黄梓强 /n 创建时间 2019.6.3")
    public Result<PageResult<UserRespVO>> findPageUserByMany(@RequestBody UserPageQueryByManyReqVO reqVO){
        UserPageQueryByManyReqDTO reqDTO=ConverUtils.converOne(reqVO,UserPageQueryByManyReqDTO.class);
        PageResult<UserRespDTO> pageUserByMany = userService.findPageUserByMany(reqDTO);
        PageResult<UserRespVO> userRespVOPageResult=new PageResult<>();
        userRespVOPageResult.setDate(ConverUtils.converList(pageUserByMany.getDate(),UserRespVO.class));
        userRespVOPageResult.setPageNumber(pageUserByMany.getPageNumber());
        userRespVOPageResult.setPageSize(pageUserByMany.getPageSize());
        userRespVOPageResult.setTotal(pageUserByMany.getTotal());
        userRespVOPageResult.setPages(pageUserByMany.getPages());
        return Result.success(userRespVOPageResult);
    }




    public static void  nhj( Class<? extends Enum> secondStatusNodeEnumClass) throws Exception{


        Enum[] SecondStatusEnumConstants = secondStatusNodeEnumClass.getEnumConstants();

        Method sequenceMethod = secondStatusNodeEnumClass.getMethod("getSequence");
        Method descMethod = secondStatusNodeEnumClass.getMethod("getDesc");
        Method parentStatusNodeEnumMethod = secondStatusNodeEnumClass.getMethod("getParentStatusNodeEnum");
        Method leaseOrderStatusEnumMethod = secondStatusNodeEnumClass.getMethod("getLeaseOrderStatusEnum");
        for (Object obj : SecondStatusEnumConstants){
            System.out.println(obj);
            System.out.println(leaseOrderStatusEnumMethod.invoke(obj));
            System.out.println(Integer.parseInt(sequenceMethod.invoke(obj).toString()));

            // 3.调用对应方法，得到枚举常量中字段的值
            Class<?> parentNodeEnumClass = parentStatusNodeEnumMethod.invoke(obj).getClass();
            Method parentNodeEnumSequenceMethod = parentNodeEnumClass.getMethod("getSequence");
            Integer parentSequence = Integer.parseInt(parentNodeEnumSequenceMethod.invoke(parentStatusNodeEnumMethod.invoke(obj)).toString());
            System.out.println(parentSequence);

            System.out.println();
            //System.out.println("code=" + sequenceMethod.invoke(obj) + "; desc=" + getDesc.invoke(obj) + ";ParentStatusNodeEnumSequence="+byName.invoke(getParentStatusNodeEnum.invoke(obj)) +"  LeaseOrderStatusEnumName："+getLeaseOrderStatusEnum.invoke(obj).toString());
        }

    }

}
