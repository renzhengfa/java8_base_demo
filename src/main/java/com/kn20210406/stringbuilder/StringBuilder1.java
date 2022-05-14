package com.kn20210406.stringbuilder;

import org.springframework.data.relational.core.sql.In;

/*
由于String类是由final修饰的，为一个常量不可改变，一旦需要字符串的拼接就会产生新的字符串导致内存占用过高，效率低下。
StringBuilder类，线程不安全（字符串缓冲区，底层为数组byte[]但是不被final修饰）：对字符串进行操作的类
StringBuffer类,线程安全，（因为StringBuffer类的append(CharSequence s, int start, int end)方法加了锁）
 */
public class StringBuilder1 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abc");
        StringBuilder stringBuilder1 = stringBuilder.append("abc");
        System.out.println(stringBuilder + ":" + stringBuilder1);
        System.out.println(stringBuilder==stringBuilder1);//true
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.length());

        char[] ar = new char[]{'a','啊'};
        System.out.println(ar.length);
        System.out.println(ar[1]);

    }

}
