package com.knrentestbase001.arrayList;

/*
实例：
ArrayList<Integer> arrayList = new ArrayList<>();
泛型只能写引用类型数据,如果想保存基本类型数据必须使用其包装类型
两个特殊基本类型（其它都是基本数据类型首字母大写）
int Integer
char Character
 */

import java.util.ArrayList;

public class ArrayList01 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(101);
        System.out.println(arrayList.size());//2
        System.out.println(arrayList.get(0));//10
        System.out.println(arrayList);// [10, 101]
    }

}
