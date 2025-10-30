package com.hzq.test.base;

import org.junit.Test;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/8/12 15:55
 * @Version: 1.0
 */
public class TestCalculate {


    @Test
    public void testOne(){
        System.out.println(calcOne(8));
        System.out.println(calcOne(9));
    }

    public int calcOne(int n){
        return n & (n - 1);
    }



}
