package com.hzq.test.algorithm;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * 排序算法
 * @author HZQ
 * @description
 * @Date: 2020-12-15
 * @Time: 16:50
 */
public class TestSort {

    public int[] arr=new int[6];

    @Before
    public void init(){
        arr[0]=26;
        arr[1]=45;
        arr[2]=23;
        arr[3]=5;
        arr[4]=10;
        arr[5]=30;


    }

    public void print(int[] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void sort1(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("a","a");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        print(arr);
    }
}
