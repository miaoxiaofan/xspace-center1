package com.xspace.accountcenter;




import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wmiao
 * @description
 * @date 2019/4/26
 */

public class reqDto {

    public static void main(String[] args) {

        String aa = null;
        String bb = "aaaa";
        String cc = "";
        String dd = " ";



        String aaa="{\"finishTime\":\"20190507101134\",\"orderNo\":\"8355065854382454784\",\"orderTime\":\"20190507090000\",\"orderId\":\"2000000000004091\",\"orderStatus\":\"03\",\"goodsCode\":\"119050616222\"}";


        System.out.println(JSON.parseObject(aaa,MarketCenterRespVo.class));


        ConcurrentHashMap a=new ConcurrentHashMap<>();
        a.put("","");
        a.get("");
    }
}
