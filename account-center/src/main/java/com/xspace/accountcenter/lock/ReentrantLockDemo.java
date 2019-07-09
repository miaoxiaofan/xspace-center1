package com.xspace.accountcenter.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmiao
 * @description 重入锁 简单demo
 * @date 2019/6/25
 */

public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();//重入锁。
    private Condition condition = lock.newCondition();//与 wait（） 和 notify方法相同。
    public void method1(){
        try {
            lock.lock();
            System.out.println("当前线程：" + Thread.currentThread().getName() + "进入等待状态..");
            Thread.sleep(3000);
            System.out.println("当前线程：" + Thread.currentThread().getName() + "释放锁..");
            condition.await();	// Object wait
            System.out.println("当前线程：" + Thread.currentThread().getName() +"继续执行...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放锁method1");
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println("当前线程：" + Thread.currentThread().getName() + "进入..");
            Thread.sleep(3000);
            System.out.println("当前线程：" + Thread.currentThread().getName() + "发出唤醒..");
            condition.signal();		//Object notify
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放锁method2");
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ReentrantLockDemo uc = new ReentrantLockDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method2();
            }
        }, "t2");
        t1.start();

        t2.start();
    }


}

