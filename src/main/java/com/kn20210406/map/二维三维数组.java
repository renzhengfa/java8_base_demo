package com.kn20210406.map;

import java.util.Collections;

//二维数组
public class 二维三维数组 {
    public static void main(String[] args) {
        sumErWeiArray();
        sumSanWeiArray();
    }

    //二维数组
    private static void sumErWeiArray() {
        int[][] arr = {
                {1,3,5,7,9},
                {2,4,6,8,10},
                {1,3,2,9,4,5,6,3,2,1,11,108,101}
        };
        //遍历二维数组
        for(int i = 0 ; i < arr.length; i++) {
            int [] arr1 = arr[i];
            //分别求和每个一维数组
            int sum = 0;
            for (int i1 = 0; i1 < arr1.length; i1++) {
                sum += arr1[i1];
            }
            System.out.println("arr[" + i + "]长度:" + arr1.length + " arr[" + i + "]求和:" + sum);
        }
    }

    //三维数组
    private static void sumSanWeiArray() {
        int[][][] arr = {
                {
                    {2,4,6,8,10},
                    {2,4,6,8,10},
                    {1,2}
                },
                {
                    {0},
                    {2}
                },
                {
                    {1,3,2,9,4,5,6,3,2,1,11,108,101},
                    {101}
                }
        };
        //遍历三维数组
        for(int i = 0 ; i < arr.length; i++) {
            int [][] arr1 = arr[i];
            for (int i1 = 0; i1 < arr1.length; i1++) {
                int[] arr2 = arr1[i1];
                //分别求和每个一维数组
                int sum = 0;
                for (int i2 = 0; i2 < arr2.length; i2++) {
                    sum += arr2[i2];
                }
                System.out.println("arr[" + i + "][" + i1 + "]长度:" + arr2.length + " arr[" + i + "]["+ i1 + "]求和:" + sum);
            }
        }
    }
}
