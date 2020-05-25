package com.xspace.commoncenter.mthread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2019/7/10
 */

public class Test {
    public static void main(String[] args) {

        List<String> a=new ArrayList();

        a.add("a1");
        a.add("a2");
        a.add("a3");
        a.add("a4");
        a.add("a5");
        a.add("a6");
        a.add("a7");


        System.out.println("-------------"+a.size());
        for(String  item:a){
            System.out.println(item);
        }
        a.remove(5);
        System.out.println("------------->>>"+a.size());
        for(String  item:a){
            System.out.println(item);
        }


        a=a.subList(0,3);

        for(String  item:a){
            System.out.println(item);
        }
    }
}
