package com.hzq.demo.service.sportsLottery;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.model.dto.SportsLotteryCalcResultDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:08
 * @Version: 1.0
 */
public interface SportsLotteryService {

    /**
     * 通过期数查询开奖结果
     * @param term
     * @return
     */
    SportsLotteryDTO findTerm(Integer term);


    /**
     * 保存期数对应开奖结果
     * @param term
     * @return
     */
    SportsLotteryDTO saveSportsLotteryByTerm(Integer term);

    /**
     * 通过期数范围保存大乐透结果
     * @param beginTerm
     * @param endTerm
     * @return
     */
    List<Integer> saveSportsLotteryByTermRange(Integer beginTerm,Integer endTerm);

    /**
     * 从之前count期预测
     * @param term
     * @param count
     * @param returnCalcList 是否返回计算结果
     * @return
     */
    SportsLotteryCalcResultDTO calcSportsLottery(Integer term, Integer count,Boolean returnCalcList);


    /**
     * 在期数和次数范围内计算
     * @param endTerm 截止期数
     * @param termCount 期数计算次数
     * @param beginCount 起始次数
     * @param timeCount 次数计算次数
     * @param isFilter 是否过滤亏本选项
     * @param returnCalcList 是否返回计算结果
     * @return
     */
    List<SportsLotteryCalcResultDTO> calcSportsLotteryListByTermRangeAndCountRange(Integer endTerm, Integer termCount,Integer beginCount, Integer timeCount,Boolean isFilter,Boolean returnCalcList);

    /**
     * 验证想法
     * @param idea
     * @return
     */
    Boolean verifyIdea(String idea);

}
