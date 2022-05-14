package com.kn20210406.map;

import com.knrentestbase001.duotai.Teacher;
import com.sun.corba.se.impl.orb.ParserTable;

import java.lang.reflect.Array;
import java.util.*;

/*
map集合：双列集合<key, value>
特点：1、双列集合
     2、key和value数据类型可以一样，也可以不一样
     3、map中的key不可以重复，value可以重复
     4、key和value一一对应
一、HashMap : 底层是hash表，jdk1.8之前是数组+链表，jdk1.8之后是数组+链表/红黑树 (无序)
二、LinkedHashMap : 底层是hash表+链表（保证迭代的顺序）

主要方法：put(K,V)增。get(K)获取。containsKey(K)。containsValue(V)。
        keySet()返回key组成的set视图。entrySet()返回键值对映射的set视图。remove(K)。size()。
 */
public class HashMapAndLinkedHashMap1 {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        Object p1 = map.put("1", "范志毅");
        map.put(3, "qiao");
        Object p2 = map.put("2", "qiao");
        //HashMap无序
        System.out.println(map);//{1=范志毅, 2=qiao, 3=qiao}
        System.out.println(p1 + " " + p2);//null null
        System.out.println(map.get("1"));//范志毅
        System.out.println(map.containsKey("2"));//true
        System.out.println(map.containsKey(2));//false
        System.out.println(map.containsValue("qiao"));//true
        //---------------------------------------------------
        testKeySet(map);
        testEntrySet(map);
        addTeacher();
        //---------------------------------------------------
        LinkedHashMap linkedMap = new LinkedHashMap();
        Object m = linkedMap.put("1", "范志毅");
        linkedMap.put(3, "qiao");
        linkedMap.put("2", "qiao");
        //LinkedHashMap有序（hash表+链表（维护顺序））
        System.out.println(linkedMap);//{1=范志毅, 3=qiao, 2=qiao}
    }

    //keySet方法遍历map集合
    public static void testKeySet(HashMap map){
        Set set = map.keySet();
        ArrayList list = new ArrayList();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            list.add(map.get(iterator.next()));
        }
        System.out.println(list);//[范志毅, qiao, qiao]
        //加强for循环遍历set集合
//        for (Object o : set) {
//            System.out.println(o);
//        }
    }

    //entrySet方法遍历map集合
    public static void testEntrySet(HashMap map){
        Set<Map.Entry> entrySet = map.entrySet();
//        Object[] objects = entrySet.toArray();
//        System.out.println(objects);
        Iterator iterator = entrySet.iterator();
        ArrayList list = new ArrayList();
        while (iterator.hasNext()) {
            list.add(iterator.next());//将键值对添加到list集合
        }
        System.out.println(list);//[1=范志毅, 2=qiao, 3=qiao]
        //遍历集合的键值对
        for (Map.Entry entry : entrySet) {
            System.out.println("Key:" + entry.getKey() + " Val:" + entry.getValue());
            //Key:1 Val:范志毅
            //Key:2 Val:qiao
            //Key:3 Val:qiao
        }
    }

    //HashMap添加自定义类型数据
    public static void addTeacher() {
        HashMap<Teacher,String> map = new HashMap<Teacher,String>();
        map.put(new Teacher("女王",20),"毛里求斯");
        map.put(new Teacher("秦始皇",33),"秦国");
        map.put(new Teacher("普金",20),"俄罗斯");
        map.put(new Teacher("女王",20),"英国");
        //Teacher还没重写equals()和hashCode()方法
        //{Teacher{name='秦始皇', age=33}=秦国, Teacher{name='普金', age=20}=俄罗斯, Teacher{name='女王', age=20}=毛里求斯, Teacher{name='女王', age=20}=英国}
        //System.out.println(map);
        //Teacher重写equals()和hashCode()方法后
        //{Teacher{name='女王', age=20}=英国, Teacher{name='普金', age=20}=俄罗斯, Teacher{name='秦始皇', age=33}=秦国}
        System.out.println(map);
    }

}
