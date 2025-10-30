package com.hzq.demo.control.sportsLottery.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:19
 * @Version: 1.0
 */
@Data
public class SportsLotteryVO implements Serializable {

    /**
     * 期数
     */
    private Integer term;

    /**
     * 前一
     */
    private String frontOne;

    /**
     * 前二
     */
    private String frontTwo;

    /**
     * 前三
     */
    private String frontThree;

    /**
     * 前四
     */
    private String frontFour;

    /**
     * 前五
     */
    private String frontFive;

    /**
     * 后一
     */
    private String backOne;

    /**
     * 后二
     */
    private String backTwo;

    /**
     * 开奖结果
     */
    private String resultCode;

    /**
     * 开奖时间
     */
    private Date openTime;
}
