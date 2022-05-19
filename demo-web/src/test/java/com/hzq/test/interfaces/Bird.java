package com.hzq.test.interfaces;

/**
 * @author HZQ
 * @description
 * @Date: 1/21/21
 * @Time: 4:34 PM
 */
public class Bird implements Animal {

    @Override
    public void fly() {
        System.out.println("鸟会飞啊飞");
    }
}
