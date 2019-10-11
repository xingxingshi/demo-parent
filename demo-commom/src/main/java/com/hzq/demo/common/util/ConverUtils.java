package com.hzq.demo.common.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author HZQ
 * @description 对象转换类
 * @Date: 2019-05-31
 * @Time: 14:12
 */
public class ConverUtils {

    public static <T> T converOne(Object orig, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(orig), clazz);
    }

    public static <T> List<T> converList(Object orig, Class<T> clazz) {
        return JSON.parseArray(JSON.toJSONString(orig), clazz);
    }
}
