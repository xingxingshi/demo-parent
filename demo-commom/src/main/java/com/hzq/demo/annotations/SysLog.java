package com.hzq.demo.annotations;

import java.lang.annotation.*;

/**
 * @author HZQ
 * @description 方法调用日志注解
 * @Date: 2019-10-11
 * @Time: 10:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
