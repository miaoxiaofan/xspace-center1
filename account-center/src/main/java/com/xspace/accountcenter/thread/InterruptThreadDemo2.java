package com.xspace.accountcenter.thread;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 */

public class InterruptThreadDemo2 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptThreadDemo2(),"InterruptThreadDemo2");
        testThread.start();

        Thread.sleep(300);
        testThread.interrupt();

        System.out.println("主线程 结束");

    }

    @Override
    public void run() {
        int  i=0;
        while(true){

            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running " +i++);

            }else{
                System.out.println("not yet interrupted   "  +i++);
            }
            waitTime(100);
            if(i>10){
                try {
                    System.out.println("子线程 开始睡眠");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    i=0;
                    e.printStackTrace();
                }
            }
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