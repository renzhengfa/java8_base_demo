package com.knrentestbase001.array;

import java.util.Arrays;

/*
1.数组长度一旦确定就不会改变
2.数组只可以存放一个数据类型的数据
3.直接打印数组名字实际上是打印的数组的内存地址hash值。

java中的内存划分
1、栈：存放的都是局部变量（一旦离开作用域立刻从栈内存中消失）,方法在栈内存中运行
2、堆：new出来的东西,堆内存中都有地址值（16进制）都有默认值（int 0, 浮点 0.0, 布尔 false, 引用类型 null）
3、方法区：存储.class相关信息,包含方法信息

4、寄存器：与CPU有关
5、本地方法栈：与操作系统有关
 */

public class ArrayTest01 {

    public static void main(String[] args) {
        double[] array1 = new double[12];

        for(int i = 0; i < array1.length; i++){
            array1[i] = i  + 1;
        }
        //[D@2f2c9b19
        System.out.println(array1);
        //[D@2f2c9b19
        System.out.println(array1.toString());
        //[[D@2f2c9b19]
        System.out.println(Arrays.asList(array1));
        //[[D@2f2c9b19]
        System.out.println(Arrays.asList(array1).toString());
        for (double a: array1) {
            System.out.println(a);
        }
        System.out.println(array1[1]);
        System.out.println("===============");

        //翻转数组
        double[] array2 = revers(array1);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println(Arrays.toString(array1));
        System.out.println("arr:" + array2);//arr: [D@2f2c9b19

        System.out.println(array1.length/2);

        Object[] arr = new Object[2];
        arr[1] = "arr1";
        arr[0] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(array2));

    }

    /*
    翻转数组元素
     */
    public static double[] revers(double[] arr){
        System.out.println("arr: " + arr);//arr: [D@2f2c9b19
        for (int i = 0; i < arr.length; i++) {
            if (i >= arr.length/2) break;
            double temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return arr;
    }

}
