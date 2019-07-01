package com.xspace.accountcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
public class AccountCenterApplication1111 {





    public static void main(String[] args) {
        SpringApplication.run(AccountCenterApplication1111.class, args);


        ExecutorService executorService = Executors.newCachedThreadPool();

        int size = 50;

        CountDownLatch countDownLatch=new CountDownLatch(size);



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


                            countDownLatch.countDown();




                        System.out.println("睡眠" + finalI);




                    }
                });
            }




            countDownLatch.await();







            System.out.println("睡眠结束,返回结果");



        } catch (Exception  e) {
            e.printStackTrace();
        }

    }








}

