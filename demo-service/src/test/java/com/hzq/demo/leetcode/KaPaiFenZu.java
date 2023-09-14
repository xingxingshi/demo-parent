package com.hzq.demo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author HZQ
 * @description 卡牌分组
 * @Date: 2019-11-20
 * @Time: 19:41
 */
public class KaPaiFenZu {

    public static void main(String[] args) {

        String s="[1,1]";
        List<Integer> integers = JSON.parseArray(s, int.class);
        int[] deck=new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            deck[i]=integers.get(i);
        }

        System.out.println(hasGroupsSizeX1(deck));
        System.out.println(hasGroupsSizeX2(deck));

    }

    public static boolean hasGroupsSizeX1(int[] deck) {
        Integer split=1;
        Integer length=deck.length;
        Map<Integer,Integer> storageMap=new HashMap<>();

        while(true){
            split++;
            if(split>length){
                return false;
            }
            if(length%split!=0){
                continue;
            }
            for (int i : deck) {
                Integer integer = storageMap.get(i);
                if(Objects.isNull(integer)){
                    storageMap.put(i,1);
                }else {
                    if(Objects.equals(split,integer+1)){
                        storageMap.remove(i);
                    }else {
                        storageMap.put(i,integer+1);
                    }
                }
                if(storageMap.size()>length-i+1){
                    break;
                }
            }
            if(storageMap.size()==0){
                return true;
            }
            storageMap.clear();
        }
    }

    public static boolean hasGroupsSizeX2(int[] deck) {
        Integer split=1;
        Integer length=deck.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i : deck) {
            if(countMap.containsKey(i)){
                countMap.put(i,countMap.get(i)+1);
            }else {
                countMap.put(i,1);
            }
        }
        Boolean flag=true;
        while(true){
            split++;
            if(split>length){
                return false;
            }
            if(length%split!=0){
                continue;
            }
            flag=true;
            for (Integer value : countMap.values()) {
                if(value%split!=0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
    }
}
