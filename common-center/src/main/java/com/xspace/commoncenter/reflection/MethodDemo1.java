package com.xspace.commoncenter.reflection;

import com.xspace.commoncenter.reflection.entity.AbilityServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

public class MethodDemo1 {

    public static void main(String[] args) {
        test1();
    }

    static void test1(){


       Class<AbilityServiceImpl>  abilityServiceClass = AbilityServiceImpl.class;

        try {
            AbilityServiceImpl newInstance = abilityServiceClass.newInstance();
            Method method = abilityServiceClass.getMethod("writeLog", String.class,String.class);
            method.invoke(newInstance,"this is my world","10000");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
