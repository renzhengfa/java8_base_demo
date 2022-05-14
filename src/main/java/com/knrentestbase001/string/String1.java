package com.knrentestbase001.string;

/*
字符串是常量，一旦创建，不可改变
字符串常量池：只要是直接String str = "abc";等于一个字符串的都在字符串常量池中
==比较：一般数据类型是比较值,引用数据类型是比较内存地址值。

如果要比较引用类型数据的内容时：可以使用equals方法
常用方法：equals,
 */
public class String1 {

    public static void main(String[] args) {

        String a = "abc";
        String b = "abc";

        byte[] b1 = {'a','b','c'};
        String c = new String(b1);

        System.out.println(a == b); //true
        System.out.println(a == c); //false
        System.out.println(b == c); //false
        System.out.println(a.equals(b)); //true
        System.out.println(a.equals(c)); //true

        Object[] objects = {new String1(), 1, 2};
        for (int i = 0; i < objects.length; i++) {
            System.out.println(i);
        }

        System.out.println(a.charAt(1));//b
        System.out.println(a.length());//3
        System.out.println(a.concat("def"));//abcdef
        System.out.println(a.indexOf(1));//-1 没有返回-1，有的话取第一次出现的索引值
        System.out.println(a.indexOf('c'));//2

        //截取字符串
        String substring = "abcdefabcdefabc".substring(1, 4);
        System.out.println(substring);//bcd

        int i = 2147483647;

        float f = 1.2f;
        System.out.println(1.2*f);//1.440000057220459
    }

}
