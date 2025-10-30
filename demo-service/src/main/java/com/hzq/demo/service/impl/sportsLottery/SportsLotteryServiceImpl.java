package com.hzq.demo.service.impl.sportsLottery;

import com.alibaba.fastjson.JSON;
import com.hzq.demo.dao.auto.SportsLotteryMapper;
import com.hzq.demo.model.auto.SportsLottery;
import com.hzq.demo.model.dto.CalcSportLotteryDTO;
import com.hzq.demo.model.dto.SportsLotteryCalcResultDTO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import com.hzq.demo.service.adapter.RollToolsApiAdapter;
import com.hzq.demo.service.impl.sportsLottery.convert.SportsLotteryConvert;
import com.hzq.demo.service.impl.sportsLottery.util.SportsLotteryStrategy;
import com.hzq.demo.service.impl.sportsLottery.util.SportsLotteryUtil;
import com.hzq.demo.service.sportsLottery.SportsLotteryService;
import com.hzq.demo.util.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:11
 * @Version: 1.0
 */
@Slf4j
@Service
public class SportsLotteryServiceImpl implements SportsLotteryService {

    @Autowired
    private RollToolsApiAdapter rollToolsApiAdapter;

    @Autowired
    private SportsLotteryMapper sportsLotteryMapper;

    @Override
    public SportsLotteryDTO findTerm(Integer term) {
        return rollToolsApiAdapter.findSportsLotteryByTerm(term);
    }

    @Override
    public SportsLotteryDTO saveSportsLotteryByTerm(Integer term) {
        SportsLottery SportsLotteryTerm = sportsLotteryMapper.selectByTerm(term);
        if(Objects.nonNull(SportsLotteryTerm)){
            log.info("期数{} 已经保存，跳过该期数",term);
            return null;
        }
        SportsLotteryDTO SportsLotteryByTerm = rollToolsApiAdapter.findSportsLotteryByTerm(term);
        //QPS限制，每次调用完都要延迟一秒钟
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(Objects.isNull(SportsLotteryByTerm)){
            log.info("期数{} 查询开奖结果错误，跳过该期数",term);
            return null;
        }
        SportsLottery SportsLottery = SportsLotteryConvert.INSTANCE.toSportsLottery(SportsLotteryByTerm);
        SportsLottery.setId(term);
        SportsLottery.setCreateTime(new Date());
        SportsLottery.setModifyTime(new Date());
        log.info("期数{}保存对应开奖结果{}",term, JSON.toJSONString(SportsLottery));
        sportsLotteryMapper.insert(SportsLottery);
        return SportsLotteryByTerm;
    }

    @Override
    public List<Integer> saveSportsLotteryByTermRange(Integer beginTerm, Integer endTerm) {
        List<Integer> saveTerms = new ArrayList<>();
        for (int term = endTerm; term > beginTerm ; term--) {
            SportsLotteryDTO SportsLotteryDTO = saveSportsLotteryByTerm(term);
            if(Objects.nonNull(SportsLotteryDTO)){
                saveTerms.add(term);
            }
        }
        return saveTerms;
    }

    @Override
    public SportsLotteryCalcResultDTO calcSportsLottery(Integer term, Integer count,Boolean returnCalcList) {
        List<SportsLottery> sportsLotteryLotteries = sportsLotteryMapper.selectTermBefore(term, count);
        List<SportsLotteryDTO> sportsLotteryDTOS = SportsLotteryConvert.INSTANCE.toSportsLotteryDTOList(sportsLotteryLotteries);

        List<CalcSportLotteryDTO> calcSportLotteryDTOS = SportsLotteryStrategy.calcMaxTimeStrategy(sportsLotteryDTOS);


        if(Objects.isNull(calcSportLotteryDTOS)){
            return null;
        }
        SportsLotteryCalcResultDTO calcResultDTO = new SportsLotteryCalcResultDTO();
        calcResultDTO.setCalcSportLotteryDTOS(calcSportLotteryDTOS);


        SportsLottery sportsLottery = sportsLotteryMapper.selectByTerm(term);
        calcResultDTO.setCount(count);
        calcResultDTO.setTerm(term);
        //有当前期数，才算开奖结果是否可用
        if(Objects.isNull(sportsLottery)){
            return calcResultDTO;
        }
        SportsLotteryDTO resultSportLotty = SportsLotteryConvert.INSTANCE.toSportsLotteryDTO(sportsLottery);

        Integer cost = calcSportLotteryDTOS.size()*2;
        Integer bonus = 0;
        for (CalcSportLotteryDTO calcSportLotteryDTO : calcSportLotteryDTOS) {
            Integer money = SportsLotteryUtil.calcReturnMoney(calcSportLotteryDTO, resultSportLotty);
            calcSportLotteryDTO.setReturnMoney(money);
            calcSportLotteryDTO.setTargetTerm(resultSportLotty.getTerm());
            calcSportLotteryDTO.setCount(count);
            bonus = money + bonus;
        }
        Comparator<CalcSportLotteryDTO> calcSportLotteryDTOComparator = (c1,c2) -> c2.getReturnMoney() - c1.getReturnMoney();
        calcSportLotteryDTOS.sort(calcSportLotteryDTOComparator);
        calcResultDTO.setCost(cost);
        calcResultDTO.setTotalReturnMoney(bonus);
        calcResultDTO.setTotalProfit(bonus-cost);
        if(!returnCalcList){
            calcResultDTO.setCalcSportLotteryDTOS(null);
        }
        log.info("期数{}网前算了{}期，花费了{},中奖{}，收益了{}",term,count,cost,bonus,calcResultDTO.getTotalProfit());
        return calcResultDTO;
    }

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
    @Override
    public List<SportsLotteryCalcResultDTO> calcSportsLotteryListByTermRangeAndCountRange(Integer endTerm, Integer termCount, Integer beginCount, Integer timeCount,Boolean isFilter,Boolean returnCalcList) {
        ArrayList<SportsLotteryCalcResultDTO> calcResultDTOS = new ArrayList<>();
        for (int j = 0; j < termCount; j++) {
            Integer currentTerm = endTerm-j;
            SportsLottery sportsLottery = sportsLotteryMapper.selectByTerm(currentTerm);
            //24000这期没有 跨年后期数会有断层 重新从年开始第一期
            if(Objects.isNull(sportsLottery)){
                List<SportsLottery> sportsLotteries = sportsLotteryMapper.selectTermBefore(currentTerm, 1);
                if(CollectionUtil.isEmpty(sportsLotteries)){
                    throw new RuntimeException();
                }
                currentTerm = sportsLotteries.get(0).getTerm();
                endTerm = sportsLotteries.get(0).getTerm() + j + 1;
            }

            for (int i = 0; i < timeCount; i++) {
                Integer count = beginCount + i;
                SportsLotteryCalcResultDTO calcResultDTO = calcSportsLottery(currentTerm, count ,returnCalcList);
                if(Objects.nonNull(calcResultDTO)){
                    calcResultDTOS.add(calcResultDTO);
                }
            }
        }
        log.info(JSON.toJSONString(calcResultDTOS));

        List<SportsLotteryCalcResultDTO> onlyResult = new ArrayList<>();
        for (SportsLotteryCalcResultDTO calcResultDTO : calcResultDTOS) {
            if(calcResultDTO.getCost() ==2 ){
                onlyResult.add(calcResultDTO);
            }
        }

        //计算参数范围的时候可以选择是否有需要过滤结果
        List<SportsLotteryCalcResultDTO> upProfits = null;
        if(isFilter) {
            upProfits =  calcResultDTOS.stream().filter(e -> e.getTotalProfit() > 0).collect(Collectors.toList());
        } else {
            upProfits = calcResultDTOS;
        }
        upProfits = onlyResult;

        Comparator<SportsLotteryCalcResultDTO> profitComparator = (c1,c2) -> c2.getTotalProfit() - c1.getTotalProfit();
        upProfits.sort(profitComparator);

        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> countProfitMap = new HashMap<>();

        for (SportsLotteryCalcResultDTO sportsLotteryCalcResultDTO : upProfits) {
            SportsLotteryUtil.packTimes(countMap,sportsLotteryCalcResultDTO.getCount());
            if(Objects.isNull(countProfitMap.get(sportsLotteryCalcResultDTO.getCount()))){
                countProfitMap.put(sportsLotteryCalcResultDTO.getCount(), sportsLotteryCalcResultDTO.getTotalProfit());
            }else {
                countProfitMap.put(sportsLotteryCalcResultDTO.getCount(), countProfitMap.get(sportsLotteryCalcResultDTO.getCount()) + sportsLotteryCalcResultDTO.getTotalProfit());
            }

        }

        List<Integer> maxCount = SportsLotteryUtil.findMaxCount(countMap, 1);
        List<Integer> maxCount1 = SportsLotteryUtil.findMaxCount(countProfitMap, 1);
        log.info("计算收益结果{}",JSON.toJSONString(upProfits));
        log.info("计算收益次数少的{},个数{}",JSON.toJSONString(onlyResult),onlyResult.size());
        log.info("出现最多的次数{},次数统计结果{}",JSON.toJSONString(maxCount),maxCount.size());
        log.info("收益最多的次数{},收益了{}",JSON.toJSONString(maxCount1),countProfitMap.get(maxCount1.get(0)));
        printMoney(upProfits);
        return upProfits;
    }


    public static void printMoney(List<SportsLotteryCalcResultDTO> sportsLotteryCalcResultDTOS){
        Integer totalCost = 0;
        Integer totalReturnMoney = 0;
        for (SportsLotteryCalcResultDTO calcResultDTO : sportsLotteryCalcResultDTOS) {
            totalCost = totalCost + calcResultDTO.getCost();
            totalReturnMoney = totalReturnMoney + calcResultDTO.getTotalReturnMoney();
        }
        log.info("花费了{} 收益了{}",totalCost,totalReturnMoney);
        double v = (double) (totalReturnMoney - totalCost) / totalCost;
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        log.info("收益率{}",decimalFormat.format(v));
    }

    /**
     * 验证一些想法
     * @param idea
     * @return
     */
    @Override
    public Boolean verifyIdea(String idea) {

        //判断开奖结果一致
        List<SportsLottery> sportsLotteries = sportsLotteryMapper.selectAll();
        List<SportsLotteryDTO> sportsLotteryDTOList = SportsLotteryConvert.INSTANCE.toSportsLotteryDTOList(sportsLotteries);
        HashMap<Integer, Integer> sameMap  = new HashMap<>();


        for (int i = 0; i < sportsLotteryDTOList.size(); i++) {
            for (int j = i+1; j < sportsLotteryDTOList.size(); j++) {
                if(SportsLotteryUtil.isSameResult(sportsLotteryDTOList.get(i),sportsLotteryDTOList.get(j))){
                    sameMap.put(i,j);
                    log.info("第{}期和第{}期开奖结果相同{}",i,j,JSON.toJSONString(sportsLotteryDTOList.get(i)));
                }
            }
        }
        log.info("期数范围{},相同的有{}",sportsLotteryDTOList.size(),sameMap.size());
        return Boolean.TRUE;
    }


}
