package com.xspace.accountcenter;

import org.slf4j.MDC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wmiao
 * @description
 * @date 2019/5/13
 */

public class BBB {


    public static void main(String[] args) {

        tttt();
    }

    public static void tttt() {

        ExecutorService service = Executors.newFixedThreadPool(1);


        ThreadLocal<String> lcaol = new ThreadLocal<>();
        MDC.put("gg", "123");
        ThreadLocal loical = new ThreadLocal();
        loical.set("123");
        InheritableThreadLocal<String> bb = new InheritableThreadLocal();
        bb.set("123");
        System.out.println(MDC.get("gg"));

        for (int i = 0; i < 2; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("111" + MDC.get("gg"));

                }
            });


            new Thread(new Runnable() {
                @Override
                public void run() {

                    InheritableThreadLocal<String> cc = new InheritableThreadLocal();
                    System.out.println(bb.get());
                    System.out.println(cc.get());
                }
            }).start();




        }


    }







    String  aaa="康帅傅电子券|1";






}




