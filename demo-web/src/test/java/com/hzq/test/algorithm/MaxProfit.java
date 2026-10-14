package com.hzq.test.algorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2025/11/3 11:13
 * @Version: 1.0
 */
public class MaxProfit {

    public int[] initArray(){
        int[] prices=new int[6];
        prices[0]=4;
        prices[1]=5;
        prices[2]=6;
        return prices;
    }

    @Test
    public void testMaxProfit(){
        int[] prices=initArray();
        if(prices.length <2) {
            return;
        }
        int maxPrice = prices[0];
        int maxPriceIndex = 0;

        int buyIndex = 0;
        int sellIndex = 1;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            //剪枝 不用每次算后面最大值，如果当前最大值失效，就是过了一个峰值
            if(prices[i]== maxPrice){
                //清空最高值，重新获取最高值,如果最高值是最后二个，不用再往后算了，后面都是亏钱还数组越界了
                if((i+1)== prices.length) {
                    break;
                }
                maxPrice = prices[i+1];
                maxPriceIndex = i+1;
                for (int j = i+1; j < prices.length; j++) {
                    if (prices[j] > maxPrice) {
                        maxPrice = prices[j];
                        maxPriceIndex = j;
                    }
                }
            }
            if ((maxPrice - prices[i]) > profit) {
                profit = maxPrice - prices[i];
                buyIndex = i;
                sellIndex = maxPriceIndex;
            }
            System.out.println(String.format("第%s天买，第%s天卖，利润%s，最高点%s",buyIndex+1,sellIndex+1,profit,maxPrice));

            //鸡肋，后面如果最大值都没有利润大，就不用算了
            if(profit >= maxPrice){
                break;
            }
        }
        System.out.println(String.format("第%s天买，第%s天卖，最大利润%s",buyIndex+1,sellIndex+1,profit));
    }


    @Test
    public void testFill(){
        int[] nums2 = new int[3];
        nums2[0] =1;
        nums2[1] =2;
        nums2[2] =3;

        int[] nums1 = initArray();
        merge(nums1,3,nums2,3);
        printArr(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m--;
        n--;
        while (index >=0){
            if(m<0){
                for (int i = n; i >=0 ; i--) {
                    nums1[i]=nums2[i];
                }
                break;
            }
            //数组2没有
            if(n<0) {
                break;
            }
            if(nums1[m] > nums2[n] ){
               nums1[index] =nums1[m];
               m--;
            } else if(nums2[n] >= nums1[m] ){
                //如果一样优先把2的移过去
                nums1[index] =nums2[n];
                n--;
            }
            index--;
        }
    }

    public void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
