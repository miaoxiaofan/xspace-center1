package com.xspace.accountcenter.thread;

import com.xspace.accountcenter.CommonRsp;

import java.util.concurrent.*;

/**
 * @author wmiao
 * @description  创建线程的几种方式
 * @date 2019/6/24
 */

public class ThreadCreate {

    static void method1(){
        Thread  thread=new MyThread();
        thread.start();

    }

    static void method2(){

        Thread  thread=new Thread(()-> {
            try {
                System.out.println(System.currentTimeMillis()+":MyRunnable  is start ");
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis()+":MyRunnable  is end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();

    }


    static  void method3(){

        ExecutorService executorService=Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()+":executorService 任务开启");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":executorService 任务结束");
            }
        });


    }
    static  void method4(){

        ExecutorService executorService=Executors.newFixedThreadPool(10);
        //异步响应
        Future<CommonRsp> future= executorService.submit(new MyCallable());
        executorService.shutdown();
        try {
            //线程阻塞等待 任务结果
            CommonRsp rsp=future.get();
            System.out.println(System.currentTimeMillis()+":任务结果:"+rsp.getMsg());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

       // method1();
       // method2();
       // method3();
        method4();

    }


}
