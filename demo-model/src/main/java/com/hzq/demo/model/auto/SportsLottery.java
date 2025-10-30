package com.hzq.demo.model.auto;

import java.util.Date;

import lombok.Data;

/**
 * 体彩大乐透
 * demo_sports_lottery
 */
@Data
public class SportsLottery {
    /**
     * 主键id
     */
    private Integer id;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}