package com.xspace.commoncenter.file;


import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author wmiao   注意：需要加入多线程技术，因为单线程，先执行read，会发生死锁，因为read方法是阻塞式的，没有数据的read方法会让线程等待。
 * @description TODO
 * @date 2020/5/24 22:27
 */
public class PipedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        new PipedStreamDemo1().demo1();

    }


    public void demo1() throws IOException {

        PipedInputStream pipin = new PipedInputStream();
        PipedOutputStream pipout = new PipedOutputStream();

        pipin.connect(pipout);
        new Thread(new Output(pipout)).start();
        new Thread(new Input(pipin)).start();

    }

}

class Input implements Runnable {
    private PipedInputStream pipedInputStream;

    public Input(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @SneakyThrows
    @Override
    public void run() {


        while (true) {
            int length = -1;
            byte[] bytes = new byte[1024];
            while ((length = pipedInputStream.read(bytes)) != -1) {
                System.out.println("read:" + new String(bytes,0,length));
            }
            Thread.sleep(1000);
        }
    }
}


class Output implements Runnable {
    private PipedOutputStream pipedInputStream;

    public Output(PipedOutputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            try {
                System.out.println("write:"+i);
                pipedInputStream.write(String.valueOf("哈哈哈"+i++).getBytes());
                Thread.sleep(2000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}