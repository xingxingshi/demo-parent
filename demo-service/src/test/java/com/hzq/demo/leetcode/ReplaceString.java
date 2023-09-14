package com.hzq.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HZQ
 * @description 至少有K个重复字符的最长子串
 * @Date: 2020-06-22
 * @Time: 16:56
 */
public class ReplaceString {


    public static void main(String[] args) {
        String string = "aaabb";
        Integer k = 3;
        Integer integer = findString(string, k);
        System.out.println(integer);
    }

    private static Integer findString(String string,Integer k){
        if(string.length()<k){
            return 0;
        }
        Map<Character, Integer> calculate = calculateNumber(string);
        for (Character character : calculate.keySet()) {
            if(calculate.get(character)<k){
                string=string.replace(character,"_".charAt(0));
            }
        }
        List<String> subStrings=new ArrayList<>();
        String[] resultString = string.split("_");
        if(resultString.length==1){
            return resultString[0].length();
        }
        for (String subString : resultString) {
            if(subString.length()<k){
                continue;
            }
            subStrings.add(subString);
        }
        Integer result=0;
        for (String subString : subStrings) {
            Integer result1 = findString(subString, k);
            if(result1>result){
                result=result1;
            }
        }
        return result;

    }

    private static Map<Character, Integer> calculateNumber(String string) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            countMap.put(aChar,countMap.getOrDefault(aChar,0)+1);
        }
        return countMap;
    }
}
