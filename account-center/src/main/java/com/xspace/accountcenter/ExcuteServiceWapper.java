package com.xspace.accountcenter;

import java.util.concurrent.ExecutorService;

/**
 * @author wmiao
 * @description
 * @date 2019/5/29
 */

public class ExcuteServiceWapper {

    private ExecutorService executorService;

    private ExcuteServiceWapper(ExecutorService executorService){
        this.executorService=executorService;
    };




    public void execute(Runnable command){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //MDc
                command.run();
            }
        });

    };


}
