package com.hzq.demo.leetcode;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.hzq.demo.util.CollectionUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author HZQ
 * @description
 * @Date: 2020-09-16
 * @Time: 14:33
 */
public class TestCollection {

    @Test
    public void testArray(){
        int[] intArray = {1, 2, 3, 4, 5};
        List<Integer> integers = new ArrayList<>();
        for (int i : intArray) {
            integers.add(i);
        }
    }

    // 辅助方法：将int数组转换为Integer数组
    private static Integer[] toIntegerArray(int[] intArray) {
        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = intArray[i];
        }
        return result;
    }

    @Test
    public void testList() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(integers.size());
        System.out.println(integers.get(1));
        integers.remove(3);
        System.out.println(JSON.toJSONString(integers));
    }

    @Test
    public void testSet() {
        Set<Integer> set1= Sets.newHashSet(1,2,4,5);
        Set<Integer> set2= Sets.newHashSet(1,2,8,9);
        Set<Integer> set3= Sets.newHashSet(1,5,6,10);
        set1=Sets.intersection(set1,set2);
        set1=Sets.intersection(set1,set3);
        set1.forEach(e-> System.out.println(e));
    }

    @Test
    public void testFindAllSubList(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        List<List<Integer>> allSubList = CollectionUtil.findAllSubList(integers);
        System.out.println(JSON.toJSONString(allSubList));
    }

    @Test
    public void testFindLengthSubList(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(100);
        integers.add(200);
        integers.add(300);
        integers.add(400);
        integers.add(500);
        List<List<Integer>> allSubList = CollectionUtil.findAllSubList(integers,5);
        System.out.println(String.format("元素个数%s,子集大小%s",integers.size(),allSubList.size()));
        for (int i = 1; i <= 10; i++) {
            integers.add(i);
            allSubList = CollectionUtil.findAllSubList(integers,5);
            System.out.println(String.format("%s元素个数%s,子集大小%s",integers.size() ,integers.size(),allSubList.size()));
            //System.out.println(JSON.toJSONString(allSubList));
        }
    }

}
