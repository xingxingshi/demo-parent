package com.hzq.demo.control.sportsLottery;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.control.sportsLottery.convert.SportsLotteryWebConvert;
import com.hzq.demo.control.sportsLottery.vo.SportsLotteryVO;
import com.hzq.demo.model.dto.SportsLotteryCalcResultDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import com.hzq.demo.service.sportsLottery.SportsLotteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:15
 * @Version: 1.0
 */
@RestController
@Api("大乐透相关接口")
@RequestMapping("/sportsLottery")
public class SportsLotteryControl {

    @Autowired
    private SportsLotteryService sportsLotteryService;

    @RequestMapping(value = "/findTerm",method = RequestMethod.GET)
    @ApiOperation(value = "查询期数对应开奖",notes = "创建人：黄梓强 20231011")
    public Result<SportsLotteryVO> findTerm(@RequestParam Integer term){
        SportsLotteryDTO SportsLotteryDTO = sportsLotteryService.findTerm(term);
        return Result.success(SportsLotteryWebConvert.INSTANCE.toSportsLotteryVO(SportsLotteryDTO));
    }

    @RequestMapping(value = "/saveSportsLotteryByTerm",method = RequestMethod.GET)
    @ApiOperation(value = "保存期数对应开奖结果")
    public Result<SportsLotteryVO> saveSportsLotteryByTerm(@RequestParam Integer term){
        SportsLotteryDTO SportsLotteryDTO = sportsLotteryService.saveSportsLotteryByTerm(term);
        return Result.success(SportsLotteryWebConvert.INSTANCE.toSportsLotteryVO(SportsLotteryDTO));
    }



    @RequestMapping(value = "/saveSportsLotteryByTermRange",method = RequestMethod.GET)
    @ApiOperation(value = "保存期数范围内对应开奖结果")
    public Result<List<Integer>> saveSportsLotteryByTermRange(@RequestParam Integer beginTerm,@RequestParam Integer endTerm){
        List<Integer> termRange = sportsLotteryService.saveSportsLotteryByTermRange(beginTerm, endTerm);
        return Result.success(termRange);
    }


    @RequestMapping(value = "/calcSportsLottery",method = RequestMethod.GET)
    @ApiOperation(value = "从之前count期预测")
    public Result<SportsLotteryCalcResultDTO> calcSportsLottery(@RequestParam Integer term, @RequestParam Integer count){
        SportsLotteryCalcResultDTO sportsLotteryCalcResultDTO =  sportsLotteryService.calcSportsLottery(term, count,Boolean.TRUE);
        return Result.success(sportsLotteryCalcResultDTO);
    }

    @RequestMapping(value = "/calcSportsLotteryListByTermRangeAndCountRange",method = RequestMethod.GET)
    @ApiOperation(value = "从期数范围和次数范围预测")
    public Result<List<SportsLotteryCalcResultDTO>> calcSportsLotteryListByTermRangeAndCountRange(
            @RequestParam @ApiParam(value = "截止期数", required = true) Integer endTerm,
            @RequestParam @ApiParam(value = "期数计算次数", required = true) Integer termCount,
            @RequestParam @ApiParam(value = "起始次数", required = true) Integer beginCount,
            @RequestParam @ApiParam(value = "次数计算次数", required = true) Integer timeCount,
            @RequestParam @ApiParam(value = "是否过滤亏本选项", required = true) Boolean isFilter,
            @RequestParam @ApiParam(value = "是否返回计算结果", required = true)Boolean returnCalcList){
        List<SportsLotteryCalcResultDTO> sportsLotteryCalcResultDTOS = sportsLotteryService.calcSportsLotteryListByTermRangeAndCountRange(endTerm, termCount,beginCount ,timeCount,isFilter,returnCalcList);
        return Result.success(sportsLotteryCalcResultDTOS);
    }

    @RequestMapping(value = "/verifyIdea",method = RequestMethod.GET)
    @ApiOperation(value = "验证一些想法")
    public Result<Boolean> verifyIdea( @RequestParam @ApiParam(value = "想法编码", required = true) String idea){
        sportsLotteryService.verifyIdea(idea);
        return Result.success(Boolean.TRUE);
    }

}
