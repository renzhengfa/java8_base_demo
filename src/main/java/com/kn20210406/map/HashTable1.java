package com.kn20210406.map;

import java.util.HashMap;
import java.util.Hashtable;

/*
java.lang.HashTable:底层是一个hash表，是一个线程安全的（单线程集合，速度慢，HashMap为多线程集合，效率块）
    1、不允许存储空值空键（其它集合可以）
HashTable的子类Properties（唯一一个和IO流相关的集合）
 */
public class HashTable1 {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"aa");
        map.put("aa",null);
        map.put(null,null);
        System.out.println(map);//{null=null, aa=null}

        Hashtable<String , String > hashtable = new Hashtable<>();
        hashtable.put(null,"aa");//java.lang.NullPointerException
        System.out.println(hashtable);
    }
}
