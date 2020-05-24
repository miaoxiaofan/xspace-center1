package com.xspace.commoncenter.utils;

import org.apache.curator.shaded.com.google.common.io.Files;

import java.util.*;

public class StrUtil {

    private static final char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 生成随机串
     * @param length
     * @return
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        int range = CHARS.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS[random.nextInt(range)]);
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        Object  gg=new Object();
        gg.toString();


        HashMap map =new HashMap(8);

        map.put(new Student("a1",1),"a1");
        map.put(new Student("a2",1),"a2");
        map.put(new Student("a3",1),"a3");
        map.put(new Student("a4",2),"a4");
        map.put(new Student("a5",2),"a5");
        map.put(new Student("a6",2),"a6");
        map.put(new Student("a7",3),"a7");
        map.put(new Student("a8",4),"a8");
        map.put(new Student("a9",5),"a9");
        map.put(new Student("a10",6),"a10");
        map.put(new Student("a11",7),"a11");
        ArrayList  arrayList=new ArrayList<>();
        arrayList.add(1);
        LinkedList linkedList=new LinkedList();


        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put("a2","111");
    }


    public  static class Student{
         private String  name;
         private int  age;
         public  Student(String name,int age){
             this.age=age;
             this.name=name;
         }
        @Override
        public int hashCode() {
            return  age;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
