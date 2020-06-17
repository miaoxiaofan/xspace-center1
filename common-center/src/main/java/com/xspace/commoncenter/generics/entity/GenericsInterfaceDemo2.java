package com.xspace.commoncenter.generics.entity;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class GenericsInterfaceDemo2  implements GenericsInterfaceDemo1<String> {

    /**测试
     * @param msg
     * @return T
     */
    @Override
     public  String  getBody(String msg){
        return msg;
    };
}
