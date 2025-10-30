package com.hzq.demo.service.impl.sportsLottery.convert;

import com.hzq.demo.model.auto.SportsLottery;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:32
 * @Version: 1.0
 */
@Mapper
public interface SportsLotteryConvert {

    SportsLotteryConvert INSTANCE = Mappers.getMapper(SportsLotteryConvert.class);

    SportsLottery toSportsLottery(SportsLotteryDTO SportsLotteryDTO);

    SportsLotteryDTO toSportsLotteryDTO(SportsLottery SportsLottery);

    List<SportsLotteryDTO> toSportsLotteryDTOList(List<SportsLottery> sportsLotteryLotteries);

}
