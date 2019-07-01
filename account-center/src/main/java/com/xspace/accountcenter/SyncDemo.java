package com.xspace.accountcenter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wmiao
 * @description
 * @date 2019/5/13
 */

public class SyncDemo {





    public void  sendMsg(String actId,String i){


        System.out.println("活动ID："+actId+",num:"+i);

    }

    public void  syncSendMsg(String actId,String i){

        synchronized (actId.intern()){
            try {
                System.out.println(System.currentTimeMillis()+",活动ID："+actId+",num:"+i);
                Thread.sleep(3000);
                AtomicInteger atomicInteger;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    public  void test(){
        ExecutorService  executorService=Executors.newFixedThreadPool(50);

        for(int i=0;i<50;i++){
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    syncSendMsg(null, "1000"+finalI);

                }
            });
        }


    }

    public static void main(String[] args) {

        new SyncDemo().test();





    }


}
