package com.hzq.demo.service.impl.sportsLottery.util;

import com.hzq.demo.model.dto.CalcSportLotteryDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import com.hzq.demo.util.CollectionUtil;
import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.*;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/20 17:04
 * @Version: 1.0
 */
public class SportsLotteryUtil {

    /**
     * 对应次数+1
     * @param timeMap
     * @param code
     */
    public static void packTimes(HashMap<Integer, Integer> timeMap, Integer code){
        if(timeMap.containsKey(code)){
            timeMap.put(code,timeMap.get(code)+1);
        }else {
            timeMap.put(code,1);
        }
    }

    /**
     * 计算 目标的获取数额
     * @param calcResult 比对的
     * @param resultSportLotty
     * @return
     */
    public static Integer calcReturnMoney(CalcSportLotteryDTO calcResult, SportsLotteryDTO resultSportLotty){
        Set<Integer> targetFrontSet = calcResult.findFrontSet();
        Set<Integer> targetBackSet = calcResult.findBackSet();
        Set<Integer> resultFrontSet = resultSportLotty.findFrontSet();
        Set<Integer> resultBackSet = resultSportLotty.findBackSet();

        resultFrontSet.retainAll(targetFrontSet);
        resultBackSet.retainAll(targetBackSet);
        int font = resultFrontSet.size();
        int bask = resultBackSet.size();

        if(font ==5 && bask ==2){
            return 10000000;
        }
        if(font ==5 && bask ==1){
            return 5000000;
        }
        if(font ==5 && bask ==0){
            return 10000;
        }
        if(font ==4 && bask ==2){
            return 3000;
        }
        if(font ==4 && bask ==1){
            return 300;
        }
        if(font ==3 && bask ==2){
            return 200;
        }
        if(font ==4 && bask ==0){
            return 100;
        }
        if(font ==3 && bask ==1 ||  font ==2 && bask ==2 ){
            return 15;
        }

        if(font ==3 && bask ==0 ||  font ==1 && bask ==2  || font ==2 && bask ==1 ||  font ==0 && bask ==2){
            return 5;
        }
        return 0;
    }

    /**
     * 组装计算结果
     * @param frontList 前区
     * @param backList  后区
     * @return
     */
    public static CalcSportLotteryDTO packageCalcSportLotteryDTO(List<Integer> frontList,List<Integer> backList){
        if(Objects.isNull(frontList) || frontList.size() != 5 || Objects.isNull(backList) || backList.size() != 2) {
            return null;
        }
        CalcSportLotteryDTO calcSportLotteryDTO = new CalcSportLotteryDTO();
        calcSportLotteryDTO.setFrontOne(frontList.get(0));
        calcSportLotteryDTO.setFrontTwo(frontList.get(1));
        calcSportLotteryDTO.setFrontThree(frontList.get(2));
        calcSportLotteryDTO.setFrontFour(frontList.get(3));
        calcSportLotteryDTO.setFrontFive(frontList.get(4));
        calcSportLotteryDTO.setBackOne(backList.get(0));
        calcSportLotteryDTO.setBackTwo(backList.get(1));
        return calcSportLotteryDTO;
    }

    /**
     * 计算出现次数最多的count个 如果次数最多的相同
     * @param timeMap
     * @param count
     * @return
     */
    public static List<List<Integer>> findMaxCountCollection(HashMap<Integer, Integer> timeMap, Integer count){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> keyList = findMaxCount(timeMap,count);
        if(keyList.size()>count){
            for (int i = 1; i < count; i++) {
                //第一次出现 比正常结果少的集合
                List<Integer> smallList = findMaxCount(timeMap, count - i);
                // 到了 最后一次遍历，如果两个集合的大小还一样，就是次数全部是相同的 去全部子集
                if(i== count -1 && smallList.size() == keyList.size()){
                    return CollectionUtil.findAllSubList(smallList,count);
                }
                if(smallList.size() < count){
                    keyList.removeAll(smallList);
                    List<List<Integer>> allSubList = CollectionUtil.findAllSubList(keyList, count - smallList.size());
                    for (List<Integer> integers : allSubList) {
                        integers.addAll(smallList);
                        result.add(integers);
                    }
                    break;
                }
            }
        } else {
            result.add(keyList);
        }
        return result;
    }

    /**
     * 获取次数最多的count个 次数相同都返回
     * @param timeMap
     * @param count
     * @return
     */
    public static List<Integer> findMaxCount(HashMap<Integer, Integer> timeMap, Integer count){
        if(timeMap.size()<count){
            throw new IllegalArgumentException("次数计算错误");
        }

        ArrayList<Integer> valueList = new ArrayList<>();
        for (Integer value : timeMap.values()) {
            if(!valueList.contains(value)){
                valueList.add(value);
            }
        }
        Collections.sort(valueList,Collections.reverseOrder());

        List<Integer> keyList = new ArrayList<>();
        for (Integer value : valueList) {
            for (Map.Entry<Integer, Integer> timeEntry : timeMap.entrySet()) {
                if(value.equals(timeEntry.getValue())){
                    keyList.add(timeEntry.getKey());
                }
            }
            //当前次数是
            if(keyList.size() >= count){
                break;
            }
        }
        return keyList;
    }

    /**
     * 开奖结果是否相同
     * @param sportsLotteryOne
     * @param sportsLotteryTwo
     * @return
     */
    public static Boolean isSameResult(SportsLotteryDTO sportsLotteryOne,SportsLotteryDTO sportsLotteryTwo){
        if(Objects.isNull(sportsLotteryOne) || Objects.isNull(sportsLotteryTwo)){
            return false;
        }
        if(Objects.equals(sportsLotteryOne.getFrontOne(),sportsLotteryTwo.getFrontOne())
                && Objects.equals(sportsLotteryOne.getFrontTwo(),sportsLotteryTwo.getFrontTwo())
                && Objects.equals(sportsLotteryOne.getFrontThree(),sportsLotteryTwo.getFrontThree())
                && Objects.equals(sportsLotteryOne.getFrontFour(),sportsLotteryTwo.getFrontFour())
                && Objects.equals(sportsLotteryOne.getFrontFive(),sportsLotteryTwo.getFrontFive())
                && Objects.equals(sportsLotteryOne.getBackOne(),sportsLotteryTwo.getBackOne())
                && Objects.equals(sportsLotteryOne.getBackTwo(),sportsLotteryTwo.getBackTwo())){
            return true;
        }
        return false;
    }


    /**
     * 从集合中随机选取count个元素返回
     *
     * @param integers
     * @return
     */
    public static List<Integer> findRandomList(List<Integer> integers,Integer count) throws Exception{
        if(Objects.isNull(integers) || integers.size()<count){
            return null;
        }
        HashSet<Integer> tempSet = new HashSet<>();
        Random random = new Random();
        while (tempSet.size() < count ){
            Thread.sleep(100);
            tempSet.add(random.nextInt(integers.size()));
        }
        return new ArrayList<>(tempSet);
    }

    /**
     * 随机生成体彩大乐透
     * @param count
     * @return
     */
    public static void randomSportLottery() throws Exception{
        List<Integer> front = new ArrayList<>();
        List<Integer> back = new ArrayList<>();
        for (int i = 1; i <= 35 ; i++) {
            front.add(i);
        }
        for (int i = 1; i <= 12; i++) {
            back.add(i);
        }
        List<Integer> frontList = findRandomList(front,5);
        List<Integer> backList = findRandomList(back,2);
        System.out.println(frontList +" -- "+ backList);
    }

    public static void main(String[] args) throws  Exception{
        for (int i = 0; i < 3; i++) {
            randomSportLottery();
        }
    }

}
