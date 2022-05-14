package com.knrentestbase001.random;

import java.util.Random;
/*
生产随机数
 */
public class Random1 {

    public static void main(String[] args) {

        Random r = new Random();
        //随机产生一个int数
        int i = r.nextInt();
        System.out.println(i);

        //在某一个范围内产生随机数
//        Random r1 = new Random(100);
        //左闭区间右开区间"[)" 比如[0,3)
        int i1 = r.nextInt(3);
        System.out.println(i1);
//        int i2 = r.nextInt(-13); //java.lang.IllegalArgumentException: bound must be positive
//        System.out.println(i2);


    }

}
