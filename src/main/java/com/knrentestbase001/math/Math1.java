package com.knrentestbase001.math;

/*
Math.abs取绝对值
Math.ceil 向上取整
Math.floor 向下取整
Math.round 四舍五入
Math.random 产生一个0~1之内的随机数
 */

public class Math1 {

    public static void main(String[] args) {
        double abs = Math.abs(-4.5); //取绝对值
        System.out.println(abs);//4.5
        System.out.println(Math.ceil(4.4));//5.0
        System.out.println(Math.floor(4.5));//4.0
        System.out.println(Math.round(8.5));//9
        System.out.println(Math.round(8.4));//8
        System.out.println(Math.random());
    }

}
