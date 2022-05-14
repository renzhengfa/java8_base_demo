package com.kn20210406.collection.数据结构;


import java.util.LinkedList;
import java.util.List;

/*
1、栈：先进后出，好似压子弹（只有一个出口）
2、队列：先进先出（两个出口）
3、数组：查询快，增删慢
  查询快:因为数组的地址是连续的，我们可以用数组的首地址找到数组，可以通过数组的索引快速查找数组元素。
  增删慢:因为数组的长度数固定的，我们想要增删数据时必须要新建一个数组，把源数组的值复制过来给新数组。
4、链表：与数组相反，查询慢，增删快 例如：（上一个节点地址 ，数据 ，下一个节点地址）
  查询慢：链表地址不是连续的，每次查询都要从链表开头比对查询。
  增删快：链表增加删除一个元素对链表结构不造成影响，删除元素其实就是改变之前删除元素前后节点数据的节点地址。
 */
public class DataStructure {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(0,11);
        list.add(1,111);
        list.add(2,1);
        list.add(3,1);
        System.out.println(list);

        boolean contains = list.contains(1111);
        System.out.println(contains);
    }
}
