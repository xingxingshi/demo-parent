package com.hzq.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HZQ
 * @description 统计最大组的数目
 * @Date: 2020-06-24
 * @Time: 17:46
 */
public class SumCount {

    public static void main(String[] args) {
        int n=13;
        Map<Integer, List<Integer>> res=new HashMap<>();
        for (Integer i=1;i<n+1;i++){
            String string = i.toString();
            Integer sum=0;
            for (int k=0;k<string.length();k++){
                int i1 = Integer.parseInt(string.substring(k,k +1));
                sum=sum+i1;
            }
            if(res.containsKey(sum)){
                res.get(sum).add(i);
            }else {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                res.put(sum,integers);
            }
        }
        Integer count =0;
        Integer maxNumber=0;
        for (Integer integer : res.keySet()) {
            int size = res.get(integer).size();
            if(size>maxNumber){
                count=1;
                maxNumber=size;
            }else if(size==maxNumber) {
                count=count+1;
            }
        }
        System.out.println(count);

    }
}
