package com.xspace.commoncenter.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author wmiao
 * @description
 * @date 2019/7/8
 *  永远在synchronized的函数或对象里使用wait、notify和notifyAll，不然Java虚拟机会生成IllegalMonitorStateException。
    永远在while循环里而不是if语句下使用wait。这样，循环会在线程睡眠前后都检查wait的条件，并在条件实际上并未改变的情况下处理唤醒通知。
    永远在多线程间共享的对象上使用wait。
    notify随机通知一个阻塞在对象上的线程；notifyAll通知阻塞在对象上所有的线程。

 */

public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        //产品
        Queue<Integer> GoodsQueue = new LinkedList<>();
        int maxSize = 10;
        Producer p = new Producer(GoodsQueue, maxSize);
        Consumer c = new Consumer(GoodsQueue, maxSize);
        Thread pT = new Thread(p);
        Thread pC = new Thread(c);
        pT.start();
        pC.start();

    }
}

class Producer implements Runnable{

    private Queue<Integer> GoodsQueue;
    private int maxSize;

    public Producer(Queue<Integer> GoodsQueue, int maxSize){
        this.GoodsQueue = GoodsQueue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (GoodsQueue){
                while (GoodsQueue.size() == maxSize){
                    try{
                        System.out.println("Queue is Full");
                        GoodsQueue.wait();
                        System.out.println("生产者被唤醒");
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("生产产品 " + i);
                GoodsQueue.add(i);
                GoodsQueue.notify();
            }
        }
    }
}

class Consumer implements Runnable{

    private Queue<Integer> GoodsQueue;
    private int maxSize;

    public Consumer(Queue<Integer> GoodsQueue, int maxSize){
        this.GoodsQueue = GoodsQueue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (GoodsQueue){
                while (GoodsQueue.isEmpty()){
                    System.out.println("Queue is Empty");
                        try{
                            GoodsQueue.wait();
                            System.out.println("消费者被唤醒");
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                int v = GoodsQueue.remove();
                System.out.println("消费产品 " + v);
                GoodsQueue.notify();
            }
        }
    }
}
