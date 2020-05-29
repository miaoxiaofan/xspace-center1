package com.xspace.commoncenter.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wmiao
 * @description
 * @date 2020/5/28
 */

public class ScatterAndGatherDemo1 {


    public static void test1(String isoPath, String destPath) {
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


    public  static  void test(){
        Charset cst=Charset.forName("GBK");
        //编码器
        CharsetEncoder encoder=cst.newEncoder();
        //解码器
        CharsetDecoder decoder=cst.newDecoder();
        CharBuffer charBuffer=CharBuffer.allocate(1024);
        charBuffer.put("双击老铁");
        charBuffer.flip();
        try {
            //编码
            ByteBuffer byteBuffer = encoder.encode(charBuffer);
            System.out.println("编码后----------------");
            for(int i=0;i<byteBuffer.limit();i++){
                System.out.println(byteBuffer.get());
            }
            byteBuffer.flip();
            //解码
            System.out.println("解码后----------------");
            CharBuffer charBuffer1 = decoder.decode(byteBuffer);
            System.out.println(new String(charBuffer1.array()));
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        test();
    }

}
