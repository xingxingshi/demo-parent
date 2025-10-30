package com.hzq.demo.dao.auto;

import com.hzq.demo.model.auto.SportsLottery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportsLotteryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportsLottery record);

    int insertSelective(SportsLottery record);

    SportsLottery selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportsLottery record);

    int updateByPrimaryKey(SportsLottery record);

    SportsLottery selectByTerm(Integer term);

    List<SportsLottery> selectTermBefore(@Param("term") Integer term,@Param("count") Integer count);

    List<SportsLottery> selectAll();
}