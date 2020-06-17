package com.xspace.commoncenter.reflection;

import com.xspace.commoncenter.reflection.entity.Person;
import lombok.SneakyThrows;

/**
 * @author wmiao
 * @description
 * @date 2020/6/16
 */

public class NewInstanceDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {



    }


    @SneakyThrows
    public  void test1(){
        Class  personClazz= Person.class;
        Person p= (Person) personClazz.newInstance();
    }


}
