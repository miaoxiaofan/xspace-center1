package com.xspace.accountcenter.thread;

import com.xspace.accountcenter.CommonRsp;

import java.util.concurrent.Callable;

/**
 * @author wmiao
 * @description
 * @date 2019/6/24
 */

public class MyCallable implements Callable<CommonRsp> {
    @Override
    public CommonRsp call() throws Exception {
        System.out.println(System.currentTimeMillis()+":callable 任务开启");
        Thread.sleep(1000);
        CommonRsp commonRsp = new CommonRsp<>();
        commonRsp.setCode("0");
        commonRsp.setMsg("success");
        System.out.println(System.currentTimeMillis()+":callable 任务结束");
        return commonRsp;
    }
}
