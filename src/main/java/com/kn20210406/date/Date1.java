package com.kn20210406.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Date:表示日期和时间类，类Date表示一个时间点，可以精确到毫秒
//把时间转化为毫秒：（就是计算当前时间到时间原点的毫秒值差）
当前日期：2021-04-08 00:00:00
时间原点：1970-01-01 00:00:00(英国格林威治)中国一个加8个小时

Sim
 */
public class Date1 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();//获取系统当前时间毫秒值。
        System.out.println(l);//1617871018693
        System.out.println(1617871018693l/1000/60/60/24/365);//51

        Date date = new Date(1000l);
        System.out.println(date);//Thu Jan 01 08:00:01 CST 1970
        System.out.println(date.getTime());//1000

        //日期转化为指定格式的字符串format（）
        Date date1 = new Date(100000000000l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println(format);//1973-03-03 17:46:40
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println(format1);//1973年03月03日 17时46分40秒
        System.out.println(simpleDateFormat1);
        //指定格式的字符串转化为日期
        Date date2 = null;
        try {
            date2 = simpleDateFormat1.parse("1973年03月03日 17时46分40秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);//Sat Mar 03 17:46:40 CST 1973
    }

}
