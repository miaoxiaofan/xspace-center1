package com.xspace.commoncenter.generics.entity;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public interface GenericsInterfaceDemo1<T> {

    /**测试
     * @param msg
     * @return T
     */
      T  getBody(T msg);
}
