package com.xspace.commoncenter.generics.entity;

import java.util.List;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class GenericsClassDemo2 <T extends Car> {


    private List<T> list;
    private T  item;

    public GenericsClassDemo2() {
    }

    public T getItem() {
        System.out.println(item.toString());
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
