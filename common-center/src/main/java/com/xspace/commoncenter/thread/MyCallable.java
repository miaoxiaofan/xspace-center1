package com.xspace.commoncenter.thread;



import java.util.concurrent.Callable;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

public class MyCallable implements Callable<CommonResp> {
    @Override
    public CommonResp call() throws Exception {
        System.out.println(System.currentTimeMillis()+":callable 任务开启");
        Thread.sleep(1000);
        CommonResp commonRsp=null ;

        System.out.println(System.currentTimeMillis()+":callable 任务结束");
        return commonRsp;
    }

}
