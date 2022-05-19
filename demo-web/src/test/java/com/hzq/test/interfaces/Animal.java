package com.hzq.test.interfaces;

/**
 * @author HZQ
 * @description
 * @Date: 1/21/21
 * @Time: 4:01 PM
 */
public interface Animal {


    default void fly(){
        System.out.println("默认会飞");
    }

    default void swim(){
        System.out.println("默认会游");
    }
}
