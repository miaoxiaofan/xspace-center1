package com.xspace.commoncenter.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmiao
 * @description   简单泛型方法
 * @date 2020/6/17
 */

public class MethodDemo1 {


    public static <T> T   receive( T  m){
        return  m;
    }

    public static void main(String[] args) {
        System.out.println(receive("123"));


    }
}
