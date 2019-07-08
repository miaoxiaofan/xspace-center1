package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 */

public class YieldThreadDemo {
    public static void main(String[] args) {
        Thread  a=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a start");
                while(true){
                    System.out.println("a"+System.currentTimeMillis());
                    Thread.yield();
                }
            }
        });
        a.setPriority(7);
        a.start();


        Thread  b=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        });

    }
}
