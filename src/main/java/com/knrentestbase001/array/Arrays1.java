package com.knrentestbase001.array;

import java.util.Arrays;

/*
Arrays.sort方法
如果是数字默认是按照大小升序排列，如果是字符串，默认按照字母排序表升序排序，
如果是自定义类型数据，那么该类型需要有Comparable或者Comparable接口的支持
 */
public class Arrays1 {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,11,1,2,3};
        System.out.println(ints);//[I@2f2c9b19
        String s = Arrays.toString(ints);
        System.out.println(s);//[1, 2, 3, 4, 11, 1, 2, 3]
        Arrays.sort(ints);
        System.out.println(ints);//[I@2f2c9b19
        String s1 = Arrays.toString(ints);
        System.out.println(s1);//[1, 1, 2, 2, 3, 3, 4, 11]

    }

}
