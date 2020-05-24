package com.xspace.commoncenter.file;

import com.xspace.commoncenter.entity.Person;

import java.io.*;

/**
 * @author wmiao
 * @description TODO
 * @date 2020/5/24 22:03
 */
public class SerializableDemo1 {


    public  void writeObject(String path){

        try {
            ObjectOutputStream a=new ObjectOutputStream(new FileOutputStream(path));
            Person person = Person.builder()
                    .address("123")
                    .age(1)
                    .name("张三").build();

            a.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  void readObject(String path){

        try {
            ObjectInputStream a=new ObjectInputStream(new FileInputStream(path));
            try {
                Person  person=(Person) a.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
