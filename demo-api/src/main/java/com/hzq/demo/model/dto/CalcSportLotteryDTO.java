package com.hzq.demo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/1/12 15:35
 * @Version: 1.0
 */
@Data
public class CalcSportLotteryDTO implements Serializable {

    /**
     * 前一
     */
    private Integer frontOne;

    /**
     * 前二
     */
    private Integer frontTwo;

    /**
     * 前三
     */
    private Integer frontThree;

    /**
     * 前四
     */
    private Integer frontFour;

    /**
     * 前五
     */
    private Integer frontFive;

    /**
     * 后一
     */
    private Integer backOne;

    /**
     * 后二
     */
    private Integer backTwo;

    /**
     * 对比期数
     */
    private Integer targetTerm;

    /**
     * 往前推算的期数
     */
    private Integer count;

    /**
     * 中奖金额
     */
    private Integer returnMoney;

    public Set<Integer> findFrontSet(){
        HashSet<Integer> frontSet = new HashSet<>();
        frontSet.add(frontOne);
        frontSet.add(frontTwo);
        frontSet.add(frontThree);
        frontSet.add(frontFour);
        frontSet.add(frontFive);
        return frontSet;
    }

    public Set<Integer> findBackSet(){
        HashSet<Integer> backSet = new HashSet<>();
        backSet.add(backOne);
        backSet.add(backTwo);
        return backSet;
    }

}
