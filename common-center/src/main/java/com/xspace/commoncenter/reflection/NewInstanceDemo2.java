package com.xspace.commoncenter.reflection;

import com.xspace.commoncenter.entity.Person;
import com.xspace.commoncenter.reflection.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16 23:11
 */
public class NewInstanceDemo2 {


    public static void main(String[] args) {
        try {
           // test2();
            testField();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class studentClazz = Person.class;
        Constructor constructor = studentClazz.getConstructor(String.class, Integer.class, Integer.class);
        Student o = (Student) constructor.newInstance("1", 5, 6);

        System.out.println(o.toString());


        Student student1 = Student.builder()
                .age(1)
                .name("张三")
                .score(100).build();
        System.out.println(student1.toString());

        studentClazz.getName();
        studentClazz.getTypeParameters();
        Field[] declaredFields = studentClazz.getDeclaredFields();
        ClassLoader loader = studentClazz.getClassLoader();


    }

    public  static void testField() throws Exception{

        Class clazz= Person.class;

        //1.获取字段
        //  1.1 获取所有字段 -- 字段数组
        //     可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            System.out.print(" "+ field.getName());
        }
        System.out.println();

        //  1.2获取指定字段
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.getName());

        Person person = Person.builder().age(11).name("heheh").build();


        //2.使用字段
        //  2.1获取指定对象的指定字段的值
        Object val = field.get(person);
        System.out.println(val);

        //  2.2设置指定对象的指定对象Field值
        field.set(person, "DEF");
        System.out.println(person.getName());

        //  2.3如果字段是私有的，不管是读值还是写值，都必须先调用setAccessible（true）方法
        //     比如Person类中，字段name字段是公用的，age是私有的
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(person));
    }
}
