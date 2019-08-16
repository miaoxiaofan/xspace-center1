package com.xspace.commoncenter.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wmiao
 * @description
 * @date 2019/6/25
 */

public class CountDownLatchDemo {

    private static int  count=10;

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(count);
        ExecutorService  executorService= Executors.newCachedThreadPool();

        for(int i=0;i<count;i++){
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("子线程"+ finalI +"start");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程"+ finalI +"end");
                    latch.countDown();
                }

            });
        }



        try {
            System.out.println("++++++++++++++++等待  "+count+"个子线程执行完毕...");
            latch.await();
            System.out.println("++++++++++++++++"+count+"个子线程执行完毕...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}