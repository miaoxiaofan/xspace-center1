package com.xspace.commoncenter.clone;


import java.io.*;

class Teacher implements Serializable {

    private static final long serialVersionUID = 8723901148964L;

    private int age;

    private Name1 name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name1 getName() {
        return name;
    }

    public void setName(Name1 name) {
        this.name = name;
    }

    public Object myClone(){
        Teacher text=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);
            text=(Teacher)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}

class Name1 implements Serializable {

    private static final long serialVersionUID = 872390113109L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class CloneDemo2 {

    public static void main(String[] args){
        Name1 name1=new Name1();
        name1.setName("name1");
        Teacher t1=new Teacher();
        t1.setAge(12);
        t1.setName(name1);
        Teacher t2=(Teacher) t1.myClone();
        System.out.println(t2.getName().getName());
        name1.setName("name2");
        System.out.println(t2.getName().getName());

    }

}