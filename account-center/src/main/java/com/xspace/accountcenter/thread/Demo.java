package com.xspace.accountcenter.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wmiao
 * @description
 * @date 2019/7/4
 */

public class Demo {

    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue();

    void consumer() {
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    while (!queue.isEmpty()) {
                        String rquest = queue.poll();
                        //调用kafka 向topic 插入数据

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者");

        consumer.start();
    }

    void product() {
        Thread product = new Thread(new Runnable() {
            @Override
            public void run() {

                //当queue 为空的时
                while (queue.isEmpty()) {
                    //向queue里插入 request

                }

            }
        }, "生产者线程");
        product.start();

    }


}
