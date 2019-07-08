package com.xspace.accountcenter.lock;

import java.util.Hashtable;
import java.util.TreeMap;

/**
 * @author wmiao
 * @description
 * @date 2019/7/2
 */

public class InterrupteThread {


    public static void main(String[] args) {
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程A开始");
                    Thread.sleep(3000);
                    System.out.println("线程A睡眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A");
        a.start();

        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("线程B开始");
                    Thread.sleep(1000);
                    System.out.println("线程B  中断A");
                    a.interrupt();
                    System.out.println("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B");
        b.start();

   String aa="";

   char  aaaa ='a';

        Hashtable  hashtable=new Hashtable();
        TreeMap treeMap=new TreeMap();
    }
}
