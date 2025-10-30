package com.hzq.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/1/9 10:37
 * @Version: 1.0
 */
public class CollectionUtil<T> {

    public static boolean isEmpty(List list) {
        if (Objects.isNull(list) || list.size() == 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 获取集合的所有子集
     * @param list
     * @return
     */
    public static List<List<Integer>> findAllSubList(List<Integer> list){

        if(Objects.isNull(list) || list.size() ==0) {
            return new ArrayList<>();
        }
        return getSubList(list,list.size()-1);
    }

    /**
     * 获取集合的所有子集
     * 递归实现，先从第一个元素（下标为0）开始空集和第一个元素，后面每个元素，都是在当前的集合的情况下，有放进去和不放进去两种情况
     * @param list 集合
     * @param current 当前元素的下标
     * @return
     */
    private static <T> List<List<T>> getSubList(List<T> list,Integer current){
        List<List<T>> allSubList = new ArrayList<>();
        if(current == 0) {
            ArrayList<T> emptyList = new ArrayList<>();
            ArrayList<T> fullList = new ArrayList<>();
            fullList.add(list.get(current));
            allSubList.add(emptyList);
            allSubList.add(fullList);
            return allSubList;
        }
        List<List<T>> subList = getSubList(list, current - 1);
        for (List<T> integers : subList) {
            //原来的集合，不增加新的元素
            allSubList.add(integers);

            //复制新的集合，增加新的元素
            ArrayList<T> addList = new ArrayList<>(integers);
            addList.add(list.get(current));
            allSubList.add(addList);
        }
        return allSubList;
    }


    /**
     * 获取集合的 leng长度的子集
     * @param list
     * @param length
     * @return
     */
    public static <T> List<List<T>> findAllSubList(List<T> list,Integer length){
        if(Objects.isNull(list) || list.size() <length) {
            return new ArrayList<>();
        }
        List<List<T>> subList = getSubList(list, list.size() - 1);

        ArrayList<List<T>> result = new ArrayList<>();
        for (List<T> integers : subList) {
            if(integers.size() == length){
                result.add(integers);
            }
        }
        return result;
    }

    /**
     * 查询集合的最长递增子集
     * 如果次数相同的递增子集，都返回
     * @param list
     * @return
     */
    public static  List<Integer> findMaxIncreaseList(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        if(isEmpty(list)){
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            //先把元素放进去
            temp.add(list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j) > temp.get(temp.size()-1)){
                    temp.add(list.get(j));
                }
            }
            if(temp.size() > result.size()){
                result =temp;
            }
        }
        return result;
    }


}
