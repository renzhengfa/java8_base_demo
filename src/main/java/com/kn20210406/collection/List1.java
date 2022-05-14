package com.kn20210406.collection;

import com.knrentestbase001.string.String1;
import org.springframework.data.relational.core.sql.In;
import sun.awt.image.ImageWatched;

import java.util.*;

/*
单列集合（Collection）
遍历方式：1、增强for
         2、迭代器：Iterator iterator = collection.iterator();

 一、List
 1、ArrayList: 有序集合，允许存储重复值元素(底层是数组结构，查询快，增删慢)
 主要方法：add(int index, E element),remove(int index),get(int index),set(int index,E element)
 2、LinkedList:单链无序，双链有序，可以存储重复值元素(底层是一个链表结构，查询慢，增删快)
 主要方法：add(E element),add(int index,E element),addFirst(E element),addLast(E element),clear(),contains(Object obj)
 get(int index),remove(),pop(),push()...
 3、Vector:底层是数组
 主要方法：addElements();
 */
public class List1 {

    public static void main(String[] args) {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("0");
        collection.add("姚明");
        collection.add("麦迪");
        collection.add("科比");
        collection.add("库里");
        collection.add("tompthon");

        System.out.println(collection);

        iteratorColl(collection);
        System.out.println(collection.size());

        //增强for循环遍历集合
//        collection.set(0,"kaka");//
        for (String s : collection) {
            System.out.println(s);
        }

        LinkedList linkedList = new LinkedList();
        linkedList.add("aa");
        linkedList.add("bb");
        System.out.println(linkedList);//[aa, bb]
        linkedList.add(0,"cc");
        System.out.println(linkedList);//[cc, aa, bb]
    }

    //遍历集合Iterator
    public static void iteratorColl(Collection collection){

        if (collection.isEmpty()) return;
        Iterator iterator = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

    }

}
