package com.kn20210406.collection;

import com.knrentestbase001.duotai.Teacher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Set接口特点：1、不允许存储相同元素。 2、不能使用普通for循环遍历，没有索引
一、HashSet implements Set:
HashSet特点：1、底层是一个hash表（数组+链表 或 数组+红黑树）结构。2、无序，存储元素和取出元素顺序可能不一致。3、同Set
初始容量为：16（0-15）
存储过程：1、比较hash值是否一致，如果不一致直接存储到新的数组索引位置。
         2、如果hash值是一致的，现在要存储的值用equals方法比较值是否一致，如果不一致就将数据用链表的方式添加到数组对应索引下面，反之就不添加。
         3、如果不重写equals方法和hashcode方法时，默认调用Object的这两个方法，equals方法比较地址值，hashcode方法重写后如果值一致时hashcode值也会一致。
二、LinkedHashSet：底层是hash表+链表
有序（多了一层链表维护添加元素的顺序）+不可重复
 */
public class Set1<E> {

    public static void main(String[] args) {
        //---------------------------------------------------
        HashSet<Teacher> set = new HashSet();
        Teacher t1 = new Teacher("lucy",18);
        Teacher t2 = new Teacher("lucy",18);
        Teacher t3 = new Teacher("lucy",19);
        Teacher t4 = new Teacher("jack",18);
        set.add(t1);
        set.add(t2);
        set.add(t3);
        set.add(t4);
        //Teacher没有重写hashCode方法
        System.out.println(t1.hashCode() + " : " + t2.hashCode());//471910020 : 531885035
        System.out.println(set);//[Teacher{name='lucy', age=18}, Teacher{name='jack', age=18}, Teacher{name='lucy', age=18}, Teacher{name='lucy', age=19}]
        //Teacher重写了hashCode方法
//        System.out.println(t1.hashCode() + " : " + t2.hashCode());//103325684 : 103325684
//        System.out.println(set);//[Teacher{name='jack', age=18}, Teacher{name='lucy', age=18}, Teacher{name='lucy', age=19}]
    }

    //Set
    public Set<E> getSet(){

        HashSet set = new HashSet();
        set.add("abc");
        set.add("def");
        set.add("abc");
        Teacher teacher = new Teacher();
        teacher.setName("aa");
        Teacher teacher1 = new Teacher();
        teacher1.setName("aa");
        set.add(teacher);
        set.add(teacher1);
        set.add(teacher1);
        set.add("重地");
        set.add("通话");

        return set;
    }

}

/*
hash值：Object.hashCode();(其实就是内存地址值，内存地址是一个16进制的数值，hash值是一个10进制的数值)
hashCode方法源码：public native int hashCode();
                        native代表该方法调用的是本地操作系统的方法。
 */
class Hash1{

    public static void main(String[] args) {
        String str1 = new String("a就是c");
        String str2 = new String("a就是c");
        System.out.println("str1:" + str1 + " str1-hash:" + str1.hashCode());//str1:a就是c str1-hash:26381316
        System.out.println("str2:" + str2 + " str2-hash:" + str2.hashCode());//str2:a就是c str2-hash:26381316
        //两个特殊的hash值
        String a = new String("重地");
        String b = "通话";
        System.out.println(a.hashCode());//1179395
        System.out.println(b.hashCode());//1179395

        Teacher teacher = new Teacher();
        teacher.setName("aa");
        Teacher teacher1 = new Teacher();
        teacher1.setName("aa");
        //teacher: com.knrentestbase001.duotai.Teacher@2f2c9b19 teacher-hashcode: 791452441 (2f2c9b19为16进制的791452441)
        System.out.println("teacher: " + teacher + " teacher-hashcode: " + teacher.hashCode());
        //teacher1: com.knrentestbase001.duotai.Teacher@31befd9f teacher1-hashcode: 834600351
        System.out.println("teacher1: " + teacher1 + " teacher1-hashcode: " + teacher1.hashCode());

        add(1,2,3,4,5,6);
    }

    /*
    可变参数使用场景：(如果方法的参数个数不确定，数据类型确定就可以使用可变参数)
    如果方法参数有多个，那么可变参数一定在最后面。
    底层其实就是一个数组
     */
    public static void add(Integer...integers){
        System.out.println(integers);
        System.out.println(integers.length);
//        Collections.addAll("a");

    }

}