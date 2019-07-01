package com.xspace.accountcenter.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmiao
 * @description
 * @date 2019/6/25
 */

public class ReentrantLockAndConditionDemo {
    final ReentrantLock reentrantLock = new ReentrantLock();
    final Condition condition = reentrantLock.newCondition();


    void  test(){
        Thread thread = new Thread((Runnable) () -> {
            try {
                reentrantLock.lock();
                System.out.println("我要等一个新信号" + Thread.currentThread().getName());
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿到一个信号！！" + Thread.currentThread().getName());
            reentrantLock.unlock();
        }, "waitThread1");

        thread.start();

        Thread thread1 = new Thread((Runnable) () -> {
            reentrantLock.lock();
            System.out.println("我拿到锁了"+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("我发了一个信号！！"+ Thread.currentThread().getName());
            reentrantLock.unlock();
        }, "signalThread");

        thread1.start();
    }


    public static void main(String[] args) {

        new ReentrantLockAndConditionDemo().test();

    }

}
