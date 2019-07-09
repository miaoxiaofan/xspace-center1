package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description  线程优先级示例
 * @date 2019/6/24
 */

public class ThreadPriorityTest {
   static  void  test(){

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start:"+System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        });
       System.out.println(thread.getPriority());
       thread.start();
    }


    public static void main(String[] args) {
        test();
    }
}
