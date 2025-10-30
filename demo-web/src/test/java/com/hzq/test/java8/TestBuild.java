package com.hzq.test.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzq.demo.util.HttpUtil;
import com.hzq.test.java8.dto.Payer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/4/11 16:42
 * @Version: 1.0
 */
public class TestBuild {


    @Test
    public void testBuild(){
        Payer name = Payer.beginBuild().name("name").money("100").weight(500).build();
        System.out.println(name.print());
    }

    @Test
    public void testHttp(){
        testMedia();
    }

    private static void testMedia() {
        String url = "http://trade-main-core.souche.com/orderinfo/helpApi/modifyMediaType.json?orderNo=";
        Map<String, String> paramMap = new HashMap<String, String>();
        String test="{\"header\":[[\"order_no\"]],\"data\":[{\"order_no\":123120923217},{\"order_no\":120448413297},{\"order_no\":126719150324},{\"order_no\":129003151929},{\"order_no\":120033851928},{\"order_no\":124841922890},{\"order_no\":120682618290},{\"order_no\":121028086990},{\"order_no\":128221159890},{\"order_no\":120925198594},{\"order_no\":129120839917},{\"order_no\":127921925840},{\"order_no\":122074922198},{\"order_no\":122050957178},{\"order_no\":122197705896},{\"order_no\":121128716890}]}";
        JSONObject jsonObject = JSON.parseObject(test);
        JSONArray data = jsonObject.getJSONArray("data");
        for (Object datum : data) {
            JSONObject object = (JSONObject) datum;
            String orderNo = object.getString("order_no");
            try {
                System.out.println("orderNo:"+orderNo + HttpUtil.get(url+orderNo, paramMap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
