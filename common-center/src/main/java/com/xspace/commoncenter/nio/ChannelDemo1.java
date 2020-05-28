package com.xspace.commoncenter.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wmiao
 * @description   copy 文件
 * @date 2020/5/27
 */

public class ChannelDemo1 {


    public static void main(String[] args) {

        copy1("D:\\PowerDesigner165.exe","D:\\PowerDesigner16511111.exe");
        copy2("D:\\PowerDesigner165.exe","D:\\PowerDesigner16522222.exe");
        copy3("D:\\PowerDesigner165.exe","D:\\PowerDesigner16533333.exe");
    }

    public static void getChannel1(String path) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(path);
        FileChannel channel = inputStream.getChannel();
    }
    public static void getChannel2(String path) throws IOException {
        FileChannel channel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
    }

    /**
     *   FileChannel配合缓冲区 copy 文件
     * @param isoPath  源文件
     * @param dest  目标文件
     */
    public  static void copy1(String isoPath, String dest) {
        try {
            long time=System.currentTimeMillis();

            FileChannel iso = new FileInputStream(isoPath).getChannel();
            FileChannel dst = new FileOutputStream(dest).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (iso.read(byteBuffer) != -1) {
                byteBuffer.flip(); //切换读模式
                dst.write(byteBuffer);
                byteBuffer.clear();//清楚缓存（切换写模式）
            }

            System.out.println("copy1 endTime:"+(System.currentTimeMillis()-time)+"ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *使用内存映射文件的方式实现文件复制的功能(直接操作缓冲区)：
     * @param isoPath
     * @param destPath
     */
    public static void  copy2(String isoPath,String destPath){
        try {
            long time=System.currentTimeMillis();
            FileChannel iso=FileChannel.open(Paths.get(isoPath),StandardOpenOption.READ);
            FileChannel dest=FileChannel.open(Paths.get(destPath),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
            //内存映射文件
            MappedByteBuffer  inMapBuffer=iso.map(FileChannel.MapMode.READ_ONLY,0,iso.size());
            MappedByteBuffer  outMapBuffer=dest.map(FileChannel.MapMode.READ_WRITE,0,iso.size());
            byte[] bytes=new byte[inMapBuffer.limit()];
            inMapBuffer.get(bytes);
            outMapBuffer.put(bytes);
            System.out.println("copy2 endTime:"+(System.currentTimeMillis()-time)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *(直接操作缓冲区)：
     * @param isoPath
     * @param destPath
     */
    public static void  copy3(String isoPath,String destPath){
        try {
            long time=System.currentTimeMillis();
            FileChannel iso=FileChannel.open(Paths.get(isoPath),StandardOpenOption.READ);
            FileChannel dest=FileChannel.open(Paths.get(destPath),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
            iso.transferTo(0,iso.size(),dest);
            iso.close();
            dest.close();
            System.out.println("copy3 endTime:"+(System.currentTimeMillis()-time)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
