package com.xspace.commoncenter.generics;

import com.xspace.commoncenter.generics.entity.GenericsClassDemo1;
import com.xspace.commoncenter.generics.entity.GenericsClassDemo2;
import com.xspace.commoncenter.generics.entity.PoliceCar;

/**
 * @author wmiao
 * @description lombok  泛型写法()
 * @date 2020/6/17
 */

public class GenericsClassTest2 {

    public static void main(String[] args) {


        GenericsClassDemo2<PoliceCar> genericsClassDemo2 = new GenericsClassDemo2<>();

        PoliceCar policeCar = new PoliceCar();

        genericsClassDemo2.setItem(policeCar);
        showMsg(genericsClassDemo2);


        System.out.println(genericsClassDemo2.toString());
    }


    public static void showMsg(GenericsClassDemo2<?> g) {
        g.getItem();
    }

}
