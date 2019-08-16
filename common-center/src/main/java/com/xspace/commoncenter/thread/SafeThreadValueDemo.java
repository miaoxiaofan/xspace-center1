package com.xspace.commoncenter.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wmiao
 * @description   线程安全访问  静态变量
 * @date 2019/7/8
 */

public class SafeThreadValueDemo {
    public  static  Integer  number=0;
    public static void main(String[] args) {
        //Integer   initNumber=0;
        CountDownLatch countDownLatch=new CountDownLatch(1000);
        ExecutorService  executorService= Executors.newFixedThreadPool(1000);

        for (int i=0;i<500;i++ ){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    synchronized (number) {
                        number++;
                        System.out.println(Thread.currentThread() + " add ，当前num:" + number);
                        countDownLatch.countDown();
                    }
                }
            });
        }
        for (int i=0;i<500;i++ ){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    synchronized (number) {
                        number--;
                        System.out.println(Thread.currentThread() + " delete,当前num:" + number);
                        countDownLatch.countDown();
                    }
                }
            });
        }
        executorService.shutdown();

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread()+" 所有子线程结束，当前num:" +number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
