package com.xspace.commoncenter.thread;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 */

public class YieldThreadDemo2 implements Runnable {

    private Integer priority;
    private String name;

    public YieldThreadDemo2(String name, Integer priority) {
        this.name = name;
        this.priority = priority;
    }
    public static void main(String[] args) throws InterruptedException {

        Thread mid= new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println( Thread.currentThread().getName()+"开始任务" +Thread.currentThread().getPriority());
                 waitTime(1000);
                 Thread.yield();
                 System.out.println( Thread.currentThread().getName()+"结束任务");
             }
         },"mid");
        Thread low= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName()+"开始任务" +Thread.currentThread().getPriority());
                waitTime(1000);
                System.out.println( Thread.currentThread().getName()+"结束任务");
            }
        },"low");
        Thread high= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName()+"开始任务" +Thread.currentThread().getPriority());
                waitTime(1000);
                System.out.println( Thread.currentThread().getName()+"结束任务");
            }
        },"high");

        low.setPriority(1);
        high.setPriority(10);



        low.start();
        mid.start();
        high.start();

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
    public static void  waitTime(long millon ){
        Long current= System.currentTimeMillis();
        while(System.currentTimeMillis() <current+millon){
        }
    }
}
