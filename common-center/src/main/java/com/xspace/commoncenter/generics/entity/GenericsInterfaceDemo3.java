package com.xspace.commoncenter.generics.entity;

/**    未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 如果不声明泛型，如：class GenericsInterfaceDemo3 implements GenericsInterfaceDemo1<T>，编译器会报错："Unknown class"
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class GenericsInterfaceDemo3 <T> implements GenericsInterfaceDemo1<T> {

    /**测试
     * @param msg
     * @return T
     */
    @Override
     public T  getBody(T msg){
        return msg;
    };
}
