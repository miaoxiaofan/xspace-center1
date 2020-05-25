package com.xspace.commoncenter.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author wmiao
 * @description
 * @date 2019/8/27
 */

public class JsonTest {
    private  static Logger logger = LoggerFactory.getLogger(JsonTest.class);

    public static void main(String[] args) {
        String str = "{\n" +
                "\t\"UNI_BSS_BODY\":{\n" +
                "\t\t\"CARD_DATA_QRY_RSP\":{\n" +
                "\t\t\t\"STATUS\":\"123\",\n" +
                "\t\t\t\"MSG\":\"123\",\n" +
                "\t\t\t\"TXID\":\"123\",\n" +
                "\t\t\t\"RSP\":{\n" +
                "\t\t\t\t\"RSP_CODE\":\"123\",\n" +
                "\t\t\t\t\"RSP_DESC\":\"123\",\n" +
                "\t\t\t\t\"SUB_CODE\":\"123\",\n" +
                "\t\t\t\t\"SUB_DESC\":\"123\",\n" +
                "\t\t\t\t\"DATA\":[{\n" +
                "\t\t\t\t\t\"cardData\":\"123\",\n" +
                "\t\t\t\t\t\"accessType\":\"123\",\n" +
                "\t\t\t\t\t\"scriptSeq\":\"1\",\n" +
                "\t\t\t\t\t\"orderType\":\"1\",\n" +
                "\t\t\t\t\t\"iccid\":\"1\",\n" +
                "\t\t\t\t\t\"procId\":\"1\",\n" +
                "\t\t\t\t\t\"cardType\":\"1\",\n" +
                "\t\t\t\t\t\"resKindCode\":\"1\",\n" +
                "\t\t\t\t\t\"activeId\":\"1\",\n" +
                "\t\t\t\t\t\"imsi\":\"1\",\n" +
                "\t\t\t\t\t\"capacityTypeCode\":\"1\",\n" +
                "\t\t\t\t\t\"para\":[{\n" +
                "\t\t\t\t\t\t\"paraId\":\"123\",\n" +
                "\t\t\t\t\t\t\"paraValue\":\"123\"\n" +
                "\t\t\t\t\t}]\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";


        JSONObject jsStr = JSONObject.parseObject(str);
        Map<String, Object> map = JSON.parseObject(str);
        System.out.println(jsStr);
        System.out.println(map);
        logger.info("写卡数据查询 响应结果 cardQry_response:{}", map);

        try {
            Map<String, Object> uni_bss_body = (Map<String, Object>) map.get("UNI_BSS_BODY");
            Map<String, Object> card_data_qry_rsp = (Map<String, Object>) uni_bss_body.get("CARD_DATA_QRY_RSP");
            Map<String, Object> rsp = (Map<String, Object>) card_data_qry_rsp.get("RSP");

            System.out.println(rsp.get("RSP_CODE"));

            rsp.get("RSP_CODE");


            List<Map<String, Object>> data = (List<Map<String, Object>>) rsp.get("DATA");

            System.out.println(data);

            Object  a=new Object();
            a.equals("");
            String   aaaa="";
            aaaa.equals("1");

            a.hashCode();
            System.out.println(Math.round(-1.4));
            System.out.println(Math.round(-1.5));
            System.out.println(Math.round(-1.6));
            System.out.println("-----------------");
            System.out.println(Math.round(1.4));
            System.out.println(Math.round(1.5));
            System.out.println(Math.round(1.6));

            System.out.println(a);

            new StringBuilder("1234567").reverse().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
