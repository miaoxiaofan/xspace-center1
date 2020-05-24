package com.xspace.commoncenter.file;

import java.io.*;

/**
 * @author wmiao 专门用于操作基本数据类型数据的对象
 * @description TODO
 * @date 2020/5/24 22:47
 */
public class DataStreamDemo1 {


    public void test() throws FileNotFoundException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        try {
            dos.writeInt(256);
            dos.close();
            DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
            int num = dis.readInt();
            System.out.println(num);
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
