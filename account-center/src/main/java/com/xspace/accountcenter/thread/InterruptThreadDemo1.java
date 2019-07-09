package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description  thread 线程interrupte 方法 ,子线程不堵塞情况示例
 * @date 2019/7/8
 */

public class InterruptThreadDemo1 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptThreadDemo1(),"InterruptThreadDemo1");
        testThread.start();
        Thread.sleep(2000);
        testThread.interrupt();
        System.out.println("main end");

    }

    @Override
    public void run() {
        int  i=0;
        while(true){
            i++;
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running  "  +i  );
            }else{
                System.out.println("not yet interrupted  " +i);
            }
            waitTime(500 );
        }
    }

    /**
     *   线程 不阻塞等待 ,模拟耗时计算任务
     * @param millon
     */
    public void  waitTime(long millon ){
        Long current= System.currentTimeMillis();
        while(System.currentTimeMillis() <current+millon){
        }
    }
}