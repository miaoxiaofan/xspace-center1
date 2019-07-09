package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description   join 方法   A线程 调用 B.join ；直到B线程结束，A线程一直阻塞 。
 * @date 2019/7/8
 */

public class JoinThreadDemo {
    public static void main(String[] args) {
        Thread  t1 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1  thread  start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1  thread  end");
            }
        });
        Thread  t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 thread start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 thread end");
            }
        });
        System.out.println("主任务开启");
        System.out.println("开启子任务 t1,t2");
        t1.start();
        t2.start();

        try {
            //主线程阻塞等待 A,B线程完成任务
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主任务结束");

    }
}
