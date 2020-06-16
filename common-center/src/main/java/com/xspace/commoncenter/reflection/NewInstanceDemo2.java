package com.xspace.commoncenter.reflection;

import com.xspace.commoncenter.reflection.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16 23:11
 */
public class NewInstanceDemo2 {


    public static void main(String[] args) {
        try {
            test2();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    static void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class studentClass = Student.class;
        Constructor constructor = studentClass.getConstructor(String.class, Integer.class, Integer.class);
        Student o = (Student) constructor.newInstance("1", 5, 6);

        System.out.println(o.toString());


        Student student1 = Student.builder()
                .age(1)
                .name("张三")
                .score(100).build();
        System.out.println(student1.toString());
    }
}
