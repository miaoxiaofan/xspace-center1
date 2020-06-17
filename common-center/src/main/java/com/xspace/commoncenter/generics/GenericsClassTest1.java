package com.xspace.commoncenter.generics;

import com.xspace.commoncenter.generics.entity.GenericsClassDemo1;

/**
 * @author wmiao
 * @description lombok  泛型写法
 * @date 2020/6/17
 */

public class GenericsClassTest1 {

    public static void main(String[] args) {


        GenericsClassDemo1<String> genericsClassDemo1= GenericsClassDemo1.<String>builder().body("12345").build();
        
        System.out.println(genericsClassDemo1.toString());
    }

}
