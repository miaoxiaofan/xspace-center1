package com.xspace.commoncenter.generics;

import com.xspace.commoncenter.generics.entity.BaseBean;

/**
 * @author wmiao
 * @description
 * ① 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。 不能多态。
 * ② 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。可以把？看成所有类型的父类。是一种真实的类型。
 * ③当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
 * @date 2020/6/17
 */

public class WildCardDemo1  < T extends BaseBean>{


    public String name;

    public T  sss;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  T  show( T v){
        return v;
    }

    public static void main(String[] args) {
        WildCardDemo1<?> a=new WildCardDemo1<>();
    }

}
