package com.kn20210406.calendar1;

import java.util.Calendar;

/*
Calendar日历类
获取当前年份：calendar.get(calendar.YEAR);
获取当前月份：calendar.get(calendar.MONTH);
获取当前号数：calendar.get(calendar.DAY_OF_MONTH);
 */

public class Calendar1 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        int year = calendar.YEAR;
        System.out.println(year);  //1
        System.out.println(calendar.MONTH); //2
        int i = calendar.get(calendar.YEAR);
        System.out.println(i); //2021

        system();
//        calendar.get(calendar.DAY_OF_MONTH);
    }


    public static void system() {
        //获取当前系统时间毫秒值
        long start = System.currentTimeMillis();
        for (int i = 0 ; i <= 1000000000 ;i++){
            int a = 1;
            int b = 2;
            int c = a + b;
        }
        long end = System.currentTimeMillis();
        System.out.println(start + "：" + end);
        System.out.println(end - start);

    }

}
