package com.xspace.commoncenter.file;

import com.xspace.commoncenter.entity.Person;

import java.io.*;

/**
 * @author wmiao
 * @description TODO
 * @date 2020/5/24 22:50
 */
public class ByteArrayStreamDemo1 {


    public static void main(String[] args) {
        new ByteArrayStreamDemo1().test2();
    }

    public void test() {


        ByteArrayInputStream bis = new ByteArrayInputStream("1244".getBytes());
        //创建目的：
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int ch = 0;
        while ((ch = bis.read()) != -1) {
            bos.write(ch);
        }
        System.out.println(bos.toString());
    }

    /**
     * 深克隆
     */
    public void test2(){

        Person person=Person.builder().age(1).name("lisi").address("贝宁").weight(123).build();
        System.out.println("person:"+person);
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(bos);
            objectOutputStream.writeObject(person);

           byte[] bytes= bos.toByteArray();



            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

            ObjectInputStream objectInputStream=new ObjectInputStream(bis);
            Person  personNew=(Person)objectInputStream.readObject();
            System.out.println("personNew:"+personNew);
            System.out.println(personNew.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
