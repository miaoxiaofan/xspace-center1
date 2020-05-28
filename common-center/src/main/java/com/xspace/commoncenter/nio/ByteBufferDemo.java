package com.xspace.commoncenter.nio;

import java.nio.ByteBuffer;

/**
 * @author wmiao
 * @description
 * @date 2020/5/25
 */

public class ByteBufferDemo {


    public static void main(String[] args) {
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("初始时-->limit--->"+byteBuffer.limit());
        System.out.println("初始时-->position--->"+byteBuffer.position());
        System.out.println("初始时-->capacity--->"+byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());
        System.out.println("--------------------------------------");
        // put添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());
        System.out.println("put完之后-->limit--->"+byteBuffer.limit());
        System.out.println("put完之后-->position--->"+byteBuffer.position());
        System.out.println("put完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());
        // flip 切换读模式
        byteBuffer.flip();
        System.out.println("--------------------------------------");
        System.out.println("flip完之后-->limit--->"+byteBuffer.limit());
        System.out.println("flip完之后-->position--->"+byteBuffer.position());
        System.out.println("flip完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("flip完之后-->mark--->" + byteBuffer.mark());
        byte[] bytes = new byte[byteBuffer.limit()];
        // get输出数据
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("--------------------------------------");
        System.out.println("get完之后-->limit--->"+byteBuffer.limit());
        System.out.println("get完之后-->position--->"+byteBuffer.position());
        System.out.println("get完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("get完之后-->mark--->" + byteBuffer.mark());
        // clear
        byteBuffer.clear();
        System.out.println("--------------------------------------");
        System.out.println("get完之后-->limit--->"+byteBuffer.limit());
        System.out.println("get完之后-->position--->"+byteBuffer.position());
        System.out.println("get完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("get完之后-->mark--->" + byteBuffer.mark());
    }
}
