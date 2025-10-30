package com.hzq.demo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/11/20 16:02
 * @Version: 1.0
 */
@Data
public class SportsLotteryDTO implements Serializable {

    /**
     * 期数
     */
    private Integer term;

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
     * 开奖结果
     */
    private String resultCode;

    /**
     * 开奖时间
     */
    private Date openTime;


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
