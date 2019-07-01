package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

class MyThread extends  Thread {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+":simpleThread  start");
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()+":simpleThread  end");
    }
}