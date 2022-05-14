package com.kn20210413.lambda函数式编程.数组排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaDemo3 {

    public static void main(String[] args) {
        //准备初始数据
        ArrayList<Person> personArrayList = action();
        System.out.println(personArrayList);
        //1、普通方法，根据年龄升序排序
        /*Collections.sort(personArrayList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/
        //2、Lambda表达式方法，根据年龄升序排序(有参)
//        Collections.sort(personArrayList, (Person o1,Person o2) -> {return o1.getAge() - o2.getAge();});
        //3、优化Lambda表达式方法，根据年龄升序排序(有参)
        Collections.sort(personArrayList, ( o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(personArrayList);
    }

    //准备初始数据
    private static ArrayList<Person> action() {
        ArrayList<Person> list = new ArrayList<Person>();
        Person person1 = new Person("迪丽热巴",21);
        Person person2 = new Person("Stephen",33);
        Person person3 = new Person("高见",36);
        Person person4 = new Person("哼哈",88);
        Person person5 = new Person("古力娜扎",28);
        Person person6 = new Person("迪文秦左",14);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        return list;
    }
}
