package com.hzq.demo.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/1/3 14:22
 * @Version: 1.0
 */
@Data
public class SportsLotteryCalcResultDTO implements Serializable {

    /**
     * 期数
     */
    private Integer term;

    /**
     * 中奖金额
     */
    private Integer totalReturnMoney;

    /**
     * 收益
     */
    private Integer totalProfit;

    /**
     * 花费金额
     */
    private Integer cost;

    /**
     * 往前推算的期数
     */
    private Integer count;

    /**
     * 计算中奖结果
     */
    private List<CalcSportLotteryDTO> calcSportLotteryDTOS;



}
