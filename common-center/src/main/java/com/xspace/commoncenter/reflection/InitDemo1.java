package com.xspace.commoncenter.reflection;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16
 */

public class InitDemo1 {
    public static void main(String[] args) {
         int  a=1;
        //不会初始化
        Class  clazz1=  InitBase.class;
        System.out.println("............................");
        //会初始化
        try {
            Class initDem=Class.forName("com.xspace.commoncenter.reflection.InitBase");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
