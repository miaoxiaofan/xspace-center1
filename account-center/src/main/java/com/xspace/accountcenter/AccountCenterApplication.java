package com.xspace.accountcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class AccountCenterApplication {





    public static void main(String[] args) {
        SpringApplication.run(AccountCenterApplication.class, args);


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int  size= 10;

        CyclicBarrier cyclicBarrier=new CyclicBarrier(size, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有方法结束,开始进行统计任务");
            }
        });



        try {
            for (int i = 0; i < size; i++) {
                int finalI = i;
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("睡眠" + finalI);

                        try {

                            cyclicBarrier.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }

                        System.out.println("统计任务" + finalI);
                    }
                });
            }



        } catch (Exception  e) {
            e.printStackTrace();
        }

    }





}

