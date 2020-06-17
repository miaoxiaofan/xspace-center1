package com.xspace.commoncenter.reflection;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16
 */

public class InitBase {
    static int a=1;

    static {
        System.out.println("----"+a);
    }
}
