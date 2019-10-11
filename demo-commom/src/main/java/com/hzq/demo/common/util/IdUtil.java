package com.hzq.demo.common.util;

import java.util.UUID;

/**
 * @author HZQ
 * @description id生成工具
 * @Date: 2019-10-11
 * @Time: 13:57
 */
public class IdUtil {

    /**
     * 生成不带横线的UUID
     * @return
     */
    public static String generateUUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }


}
