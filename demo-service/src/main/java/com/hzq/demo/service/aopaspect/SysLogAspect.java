package com.hzq.demo.service.aopaspect;

import com.alibaba.fastjson.JSON;
import com.hzq.demo.dao.auto.SysLogMapper;
import com.hzq.demo.model.auto.SysLogWithBLOBs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author HZQ
 * @description 方法调用日志注解切面记录日志
 * @Date: 2019-10-11
 * @Time: 11:02
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 使用注解的形式定义切点
     */
    @Pointcut("@annotation(com.hzq.demo.annotations.SysLog)")
    public void sysLog(){}


    /**
     * 切面处理
     * @param point
     * @return
     * @throws Exception
     */
    @Around("sysLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            SysLogWithBLOBs sysLog=new SysLogWithBLOBs();

            sysLog.setClassName(point.getTarget().getClass().getName());
            MethodSignature signature = (MethodSignature) point.getSignature();
            sysLog.setMethodName(signature.getName());
            sysLog.setExeuTime(time);
            sysLog.setCreateDate(new Date());
            sysLog.setParams(JSON.toJSONString(point.getArgs()));
            sysLog.setResponse(JSON.toJSONString(result));
            sysLogMapper.insert(sysLog);
        } catch (Exception e) {
        }
        return result;
    }

}
