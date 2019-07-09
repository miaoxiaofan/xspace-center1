package com.xspace.accountcenter.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 */

public class YieldThreadDemo  implements Runnable {

    private Integer priority;
    private String name;

    public YieldThreadDemo(String name,Integer priority) {
        this.name = name;
        this.priority = priority;
    }
    public static void main(String[] args) throws InterruptedException {

       ExecutorService executorService=Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                Long current= System.currentTimeMillis();
                long millon=1000;
                while(System.currentTimeMillis() <current+millon){
                }
                System.out.println(System.currentTimeMillis()+"yield start");

                Thread.yield();
                System.out.println( System.currentTimeMillis()+"yield  end ");
            }
        });
        Thread.sleep(100);
        executorService.submit(new YieldThreadDemo("name"+1,1));
        Thread.sleep(100);
        executorService.submit(new YieldThreadDemo("name"+10,10));


    }


    @Override
    public void run() {

        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);

        System.out.println( Thread.currentThread().getName()+"开始任务" +Thread.currentThread().getPriority());
        waitTime(1000);
        System.out.println( Thread.currentThread().getName()+"结束任务");
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
