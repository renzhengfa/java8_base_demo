package com.kn20210406.collection;

import com.knrentestbase001.duotai.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
对Collections集合工具类复习
主要方法：1、addAll添加元素
         2、shuffle打乱顺序（斗地主）
         3、sort(List list)排序（当list集合存储的是自定义类型数据时，该类型需要实现Comparable<自定义类型>接口并重写compareTo方法定义排序规则）
 */
public class Collections1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("10");
        list.add("8");
        list.add("2a");
        Collections.sort(list);   //升序排序
        System.out.println(list); //[1, 10, 2a, 8]

        //比较自定义类型数据
//        ArrayList<Teacher> list1 = new ArrayList<Teacher>();
//        list1.add(new Teacher("curry",18));
//        list1.add(new Teacher("stephon",21));
//        list1.add(new Teacher("curry",19));
//        Collections.sort(list1);
//        System.out.println(list1);//[Teacher{name='curry', age=18}, Teacher{name='curry', age=19}, Teacher{name='stephon', age=21}]
        //-----------------------------------------------------
        ArrayList<Teacher> list2 = new ArrayList<Teacher>();
        list2.add(new Teacher("curry",18));
        list2.add(new Teacher("stephon",21));
        list2.add(new Teacher("curry",19));
        Collections.sort(list2, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
//                return o1.getAge() - o2.getAge();//升序
                //如果自定义类型数据实现了Comparable<Teacher>接口，但是比较排序时使用的是方法自带的比较器，采用就近原则使用方法自带的比较器。
                return o2.getAge() - o1.getAge();//降序 [Teacher{name='stephon', age=21}, Teacher{name='curry', age=19}, Teacher{name='curry', age=18}]
            }
        });
        System.out.println(list2);
    }
}
