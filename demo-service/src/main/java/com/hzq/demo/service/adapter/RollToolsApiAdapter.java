package com.hzq.demo.service.adapter;

import com.alibaba.druid.util.HttpClientUtils;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzq.demo.model.dto.SportsLotteryDTO;
import com.hzq.demo.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 体彩大乐透 35选5加12选2
 * @author: HZQ
 * @createDate: 2023/11/20 15:57
 * @Version: 1.0
 */

@Slf4j
@Component
public class RollToolsApiAdapter {

    /**
     * 账号
     */
    private static final String APP_ID="psrwvlhevkoqvn8y";

    /**
     * 秘钥
     */
    private static final String APP_SECRET="4DCg4kkIaoZpJfayDtLhGjnN70QdCgmK";

    /**
     * 调用地址
     */
    private static final String URL="https://www.mxnzp.com/api/lottery/common/aim_lottery";


    /**
     * 通过期数查询结果
     * @param term
     * @return
     */
    public SportsLotteryDTO findSportsLotteryByTerm(Integer term){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("expect", term.toString());
        paramMap.put("code", "cjdlt");
        paramMap.put("app_id", APP_ID);
        paramMap.put("app_secret", APP_SECRET);
        String respone ="";
        try {
            respone = HttpUtil.get(URL, paramMap);
        }catch (Exception e) {
            e.printStackTrace();
        }
        log.info("期数{}查询开奖结果{}",term,respone);
        JSONObject result = JSON.parseObject(respone);
        if( !Objects.equals(1,result.getInteger("code"))){
            log.error("期数{}查询开奖结果返回错误",term);
            return null;
        }
        JSONObject data = result.getJSONObject("data");
        String openCode = data.getString("openCode");
        String[]  font = openCode.split(",");
        String[] back = font[4].split("[+]");
        SportsLotteryDTO SportsLotteryDTO = new SportsLotteryDTO();
        SportsLotteryDTO.setTerm(term);
        SportsLotteryDTO.setFrontOne(Integer.parseInt(font[0]));
        SportsLotteryDTO.setFrontTwo(Integer.parseInt(font[1]));
        SportsLotteryDTO.setFrontThree(Integer.parseInt(font[2]));
        SportsLotteryDTO.setFrontFour(Integer.parseInt(font[3]));
        SportsLotteryDTO.setFrontFive(Integer.parseInt(back[0]));
        SportsLotteryDTO.setBackOne(Integer.parseInt(back[1]));
        SportsLotteryDTO.setBackTwo(Integer.parseInt(back[2]));
        SportsLotteryDTO.setResultCode(openCode);
        SportsLotteryDTO.setOpenTime(data.getDate("time"));
        return SportsLotteryDTO;
    }

}
