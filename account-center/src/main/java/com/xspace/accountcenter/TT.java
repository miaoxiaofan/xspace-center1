package com.xspace.accountcenter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.n3.ecs.open.util.HMACUtil;
import com.n3.ecs.open.util.SignUtil;
import org.slf4j.impl.StaticMDCBinder;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author wmiao
 * @description
 * @date 2019/4/23
 */

public class TT {

    public static void main(String[] args) throws Exception {

        String msg = "{\"activity\":\"1\",\"date\":\"2\",\"address\":\"\"}";
        String msg1 = "{}";
        String SEPARATE = "|";
        JSONObject jsonObject = JSONObject.parseObject(msg);




        String parms = "";
        LinkedHashMap<String, Object> contentMap = JSON.parseObject(msg1, LinkedHashMap.class, Feature.OrderedField);

        for (String key : contentMap.keySet()) {
            parms = parms + SEPARATE + contentMap.get(key);
        }
        System.out.println(parms);
        parms=parms.replaceFirst("\\|","");
       // parms=parms.replace("\\|","a");
        System.out.println(":"+parms);

 Double a=10.0;
 String  b="0.69";
        BigDecimal price=new BigDecimal(a);
        BigDecimal  rate=new BigDecimal(b);
        Double result=price.multiply(rate).doubleValue();
        System.out.println(result);
    }
}
