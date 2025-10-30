package com.hzq.demo.sportLottert;

import com.alibaba.fastjson.JSON;
import com.hzq.demo.service.impl.sportsLottery.util.SportsLotteryUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/1/5 16:36
 * @Version: 1.0
 */
public class SportLottyUtilTest {

    HashMap<Integer, Integer> timeMap = new HashMap<>();

    @Before
    public void before(){
        timeMap.put(5,1);
        timeMap.put(6,2);
        timeMap.put(7,2);
        timeMap.put(8,2);
        timeMap.put(9,2);
    }

    @Test
    public void testFindMaxCountCollection(){
        List<List<Integer>> maxCountCollection = SportsLotteryUtil.findMaxCountCollection(timeMap, 3);
        System.out.println(JSON.toJSONString(maxCountCollection));
    }

    @Test
    public void testFindMaxCount(){
        List<Integer> maxCount = SportsLotteryUtil.findMaxCount(timeMap,3 );
        System.out.println(JSON.toJSONString(maxCount));
    }
}
