package com.hzq.demo.control.sportsLottery.convert;

import com.hzq.demo.control.sportsLottery.vo.SportsLotteryVO;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2023/12/4 17:18
 * @Version: 1.0
 */
@Mapper
public interface SportsLotteryWebConvert {

    SportsLotteryWebConvert INSTANCE = Mappers.getMapper(SportsLotteryWebConvert.class);

    SportsLotteryVO toSportsLotteryVO(SportsLotteryDTO SportsLotteryDTO);

    List<SportsLotteryVO> toSportsLotteryVOList(List<SportsLotteryDTO> SportsLotteryDTOS);


}
