package com.hzq.demo.leetcode;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author HZQ
 * @description
 * @Date: 2020-09-16
 * @Time: 14:33
 */
public class TestCollection {

    public static void main(String[] args) {
        Set<Integer> set1= Sets.newHashSet(1,2,4,5);
        Set<Integer> set2= Sets.newHashSet(1,2,8,9);
        Set<Integer> set3= Sets.newHashSet(1,5,6,10);
        set1=Sets.intersection(set1,set2);
        set1=Sets.intersection(set1,set3);
        set1.forEach(e-> System.out.println(e));
    }
}
