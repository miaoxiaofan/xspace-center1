package com.xspace.accountcenter;

import com.alibaba.fastjson.JSONObject;
import com.n3.ecs.open.util.HMACUtil;
import com.n3.ecs.open.util.SignUtil;
import org.slf4j.impl.StaticMDCBinder;


import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author wmiao
 * @description
 * @date 2019/4/23
 */

public class TT {

    public static void main(String[] args) throws Exception {

        Calendar  calendar=Calendar.getInstance();

        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
    }
}
