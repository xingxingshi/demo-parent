package com.hzq.demo.service.impl.sportsLottery.util;

import com.hzq.demo.model.auto.SportsLottery;
import com.hzq.demo.model.dto.CalcSportLotteryDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 预测策略
 * @author: HZQ
 * @createDate: 2023/12/21 15:52
 * @Version: 1.0
 */
public class SportsLotteryStrategy {


    /**
     * 根据历史开奖，计算出现次数最多的
     * 出现次数一样多的，排列组合都输出
     * @param sportsLotteryDTOS
     * @return
     */
    public static List<CalcSportLotteryDTO> calcMaxTimeStrategy(List<SportsLotteryDTO> sportsLotteryDTOS){
        HashMap<Integer, Integer> frontTimeMap = new HashMap<>();
        HashMap<Integer, Integer> backTimeMap = new HashMap<>();
        for (SportsLotteryDTO lotteryLotteryDTO : sportsLotteryDTOS) {
            SportsLotteryUtil.packTimes(frontTimeMap,lotteryLotteryDTO.getFrontOne());
            SportsLotteryUtil.packTimes(frontTimeMap,lotteryLotteryDTO.getFrontTwo());
            SportsLotteryUtil.packTimes(frontTimeMap,lotteryLotteryDTO.getFrontThree());
            SportsLotteryUtil.packTimes(frontTimeMap,lotteryLotteryDTO.getFrontFour());
            SportsLotteryUtil.packTimes(frontTimeMap,lotteryLotteryDTO.getFrontFive());
            SportsLotteryUtil.packTimes(backTimeMap,lotteryLotteryDTO.getBackOne());
            SportsLotteryUtil.packTimes(backTimeMap,lotteryLotteryDTO.getBackTwo());
        }
        List<List<Integer>> forntList = SportsLotteryUtil.findMaxCountCollection(frontTimeMap,5);
        List<List<Integer>> backList = SportsLotteryUtil.findMaxCountCollection(backTimeMap,2);
        //如果返回元素过多，会造成投入过大，这个样例就不用了
        //计算一个集合（size=n）的固定大小(k)子集的数量  C(n,k)=  n! / (k!(n−k)!)
        //C(7,5)= 21
        if(forntList.size() > 21 ) {
            return null;
        }
        //C(4,2)= 6
        if(backList.size() > 6) {
            return null;
        }
        List<CalcSportLotteryDTO> result = new ArrayList<>();
        for (List<Integer> front : forntList) {
            for (List<Integer> back : backList) {
                CalcSportLotteryDTO calcSportLotteryDTO = SportsLotteryUtil.packageCalcSportLotteryDTO(front, back);
                result.add(calcSportLotteryDTO);
            }
        }
        return result;
    }




}
