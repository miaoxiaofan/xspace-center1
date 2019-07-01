package com.xspace.accountcenter.lock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

public class WaitAndNotifyDemo {
    void test(){
      Thread thread=  new  Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("start");
            }
        });


        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("","");
    }
}
