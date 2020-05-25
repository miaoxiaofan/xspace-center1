package com.xspace.commoncenter.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wmiao
 * @description
 * @date 2019/11/14
 */

public class DTTT {

    public static void main(String[] args) throws ParseException {
        getLastTimeOfMonth(new Date());
    }

    //获取该日期 当前月的最后一天
    public  static Date getLastTimeOfMonth(Date date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

        String last = format.format(ca.getTime())+" 23:59:59";

        Date resultDate=format.parse("");
        System.out.println("===============last:"+last);
        return resultDate;
    }

}
