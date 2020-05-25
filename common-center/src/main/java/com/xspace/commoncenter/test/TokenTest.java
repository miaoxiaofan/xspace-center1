package com.xspace.commoncenter.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wmiao
 * @description
 * @date 2019/8/28
 */

public class TokenTest {

//    private String getToken(String appKey, String appSecret, String timestamp, String transId) {
////        try {
////            StringBuffer foo = new StringBuffer().append("APP_ID").append(appKey).append("TIMESTAMP").append(timestamp)
////                    .append("TRANS_ID").append(transId).append(appSecret);
////            return getMD5Encode("UTF-8", foo.toString());
////        } catch (Exception e) {
////            e.printStackTrace();
////            logger.info(e.getMessage());
////            throw new AaopException("12010");
////        }
//    }
//}


    public static void main(String[] args) throws ParseException {

        List<String> result=  getMonthBetween("2018-12-12","2019-12-12");

        for(String  ii:result){
            System.out.println(ii);
        }

        String  aa="1234567";
        aa.substring(2,4);
        System.out.println(aa.substring(2,4));


    }




    private static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }



    private static List<String> getMonthBetween1(Date minDate, Date maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        String  aa="1234567";
        aa.substring(1);
        System.out.println(aa);

        return result;
    }



}
