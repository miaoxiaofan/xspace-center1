package com.xspace.commoncenter.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wmiao
 * @description
 * @date 2020/5/28
 */

public class ScatterAndGatherDemo1 {

    public void test1(String isoPath, String destPath) {
        try {
            FileChannel iso = FileChannel.open(Paths.get(isoPath), StandardOpenOption.READ);
            FileChannel dest = FileChannel.open(Paths.get(destPath), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
            //分散读取
            ByteBuffer byteBuffer1=ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer2=ByteBuffer.allocate(512);
            ByteBuffer[] buffers={byteBuffer1,byteBuffer2};
            iso.read(buffers);
            for(ByteBuffer item:buffers){
                item.flip();
            }
            System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
            System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));


            //聚集写入
            dest.write(buffers);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
