package com.xspace.commoncenter.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Scanner;

/**
 * @author wmiao
 * @description
 * @date 2020/5/29
 */

public class DataGramChannelServerDemo1 {
    public void send() {
        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            dc.bind(new InetSocketAddress(9123));
            Selector selector=Selector.open();
            dc.register(selector, SelectionKey.OP_READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (selector.select()>0) {


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
