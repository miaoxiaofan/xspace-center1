package com.xspace.commoncenter.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

public class MyRunnable implements Runnable {


    AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+":MyRunnable  is start ");
        try {
            Thread.sleep(1000);
            System.out.println("num:"+atomicInteger.incrementAndGet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+ ":MyRunnable  is end ");
    }
}
