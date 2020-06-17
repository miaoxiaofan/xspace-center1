package com.xspace.commoncenter.clone;

import com.xspace.commoncenter.entity.Person;

/**
 * @author wmiao
 * @description
 * @date 2020/6/17
 */

 class Text implements Cloneable{

    private int age;

    private Name name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Name{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class CloneDemo1 {

    public static void main(String[] args){
        Name name1=new Name();
        name1.setName("name1");
        Text t1=new Text();
        t1.setAge(12);
        t1.setName(name1);
        Text t2=(Text) t1.clone();
        System.out.println(t2.getName().getName());
        name1.setName("name2");
        System.out.println(t2.getName().getName());

    }

}