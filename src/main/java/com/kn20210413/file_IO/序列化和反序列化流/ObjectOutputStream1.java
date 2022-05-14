package com.kn20210413.file_IO.序列化和反序列化流;

import com.kn20210413.lambda函数式编程.数组排序.Person;

import java.io.*;
import java.util.ArrayList;

/*
序列化和反序列化流（前提是该对象实现Serializable接口，标记接口）
ObjectOutputStream和ObjectInputStream
主要方法：
ObjectOutputStream writeObject(person);  ObjectInputStream  readObject();
关键字：
transient瞬态关键字,（不想被序列化的字段可以使用transient修饰）,和static功能类似但是不是随类加载而加载。
使用transient修饰age字段后：序列化的new Person("小明",18);反序列化后是Person{name='小明', age=null}
 */
public class ObjectOutputStream1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        xuLieHua();
//        fanXuLieHua();
        xuLieHeFanXuLieCool();
    }

    //序列化
    private static void xuLieHua() throws IOException {
        Person person = new Person("小明",18);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io\\序列化和反序列化.txt"));
        oos.writeObject(person);
//        oos.write(person.toString().getBytes());
        oos.close();
    }

    //反序列化
    private static void fanXuLieHua() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io\\序列化和反序列化.txt"));
        Person readObject = (Person) ois.readObject();
        System.out.println(readObject);
        //也可以像一般的输入流那样读取数据
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while ((len = ois.read(bytes))!= -1) {
//            System.out.println(new String(bytes, 0, len));
//        }
    }

    //序列化和反序列化集合
    public static void xuLieHeFanXuLieCool() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io\\序列化和反序列化1.txt"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("io\\序列化和反序列化1.txt"));
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("小美女", 18));
        list.add(new Person("大美女", 19));
        list.add(new Person("11", 3));
        oos.writeObject(list);
        ArrayList<Person> person = (ArrayList<Person>) ois.readObject();
        System.out.println(person);
    }
}
