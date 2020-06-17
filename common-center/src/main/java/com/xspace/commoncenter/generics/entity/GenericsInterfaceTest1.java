package com.xspace.commoncenter.generics.entity;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class GenericsInterfaceTest1 {
    public static void main(String[] args) {
        GenericsInterfaceDemo3<String> a=new GenericsInterfaceDemo3<>();
        System.out.println(a.getBody("1124"));

    }
}
