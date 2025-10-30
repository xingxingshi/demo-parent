package com.hzq.demo.leetcode;

import org.junit.Test;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/1/8 10:58
 * @Version: 1.0
 */
public class TestYunSuanFu {


    @Test
    public void testOne(){
        for (int i = 0; i < 20; i++) {
            System.out.println(1 << i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(25 >> i);
        }
        System.out.println(1 & 2 );

    }


}
