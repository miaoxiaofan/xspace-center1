package com.xspace.accountcenter.thread;

import java.util.concurrent.*;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 */

public class InterruptCallableDemo1 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(System.currentTimeMillis()+":callable 任务开启");
        Thread.sleep(1000);
       // waitTime(1000);
        System.out.println(System.currentTimeMillis()+":callable 任务结束");

        return "12345";
    }

    public static void main(String[] args) {
        ExecutorService  executorService= Executors.newFixedThreadPool(10);
        Future<String>  future=executorService.submit(new InterruptCallableDemo1());


       //取消任务
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(500);
                   System.out.println("取消任务");
                   future.cancel(false);
               } catch (InterruptedException e) {
                   System.out.println("-------->" +e);
                  ;
               }
           }
       }).start();

       //获取结果
        try {
            System.out.println(System.currentTimeMillis()+"future  阻塞等待结果");
            String resut=future.get();
            System.out.println(System.currentTimeMillis()+":future 结果:"+resut);

        } catch (InterruptedException e) {
            System.out.println("-InterruptedException------->" +e);
        } catch (Exception e) {
            System.out.println("---Exception----->" +e);
        }
    }

    /**
     *   线程 不阻塞等待 ,模拟耗时计算任务
     * @param millon
     */
    public void  waitTime(long millon ){
        Long current= System.currentTimeMillis();
        while(System.currentTimeMillis() <current+millon){
        }
    }

}
