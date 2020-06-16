package com.xspace.commoncenter.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * @author wmiao
 * @description
 * @date 2020/5/29
 */

public class DataGramChannelClientDemo1 {
    public void send() {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            Scanner scanner = new Scanner(System.in);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (scanner.hasNext()) {
                String msg = scanner.next();
                byteBuffer.put(msg.getBytes());
                byteBuffer.flip();
                datagramChannel.send(byteBuffer, new InetSocketAddress("127.10.0.1", 9123));
                byteBuffer.clear();

            }
            datagramChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
