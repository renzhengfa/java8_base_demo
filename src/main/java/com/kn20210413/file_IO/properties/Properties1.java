package com.kn20210413.file_IO.properties;

import java.io.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/*
唯一一个与IO流有关的集合：Properties
主要方法：key唯一
    1、setProperty(String key, String val);调用hashtable的put方法
    2、getProperty(String key);获取值,相当于map集合的get(key);
    3、Set<String> stringPropertyNames();相当于map集合的keySet();
 */
public class Properties1 {
    public static void main(String[] args) throws IOException {
//        getProperties1();
        getProperties2();
    }

    //
    public static void getProperties1() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("curry","33");
        prop.setProperty("curry","32");
        prop.setProperty("马尔扎哈","33");
        prop.setProperty("tompthon","31");
        Set<String> names = prop.stringPropertyNames();
        for (String name : names) {
            System.out.println(name + " : " + prop.getProperty(name) + " size: " + prop.size());
            //curry : 32
            //马尔扎哈 : 33
            //tompthon : 31
        }

        //将集合数据写入文件(FileWriter可以写中文，FileOutputStream不可以写中文)
        FileWriter  fw = new FileWriter("io\\44-properties.txt");
        prop.store(fw,"save data");
        fw.close();
//        FileOutputStream fos = new FileOutputStream("io\\44-properties.txt");
//        prop.store(fos,"save data");
//        fos.close();


    }

    //读取硬盘文件配置文件
    public static void getProperties2() throws IOException {
        Properties prop = new Properties();
        //将硬盘内的配置文件数据读取到内存（字节流不能读取中文，会出现乱码，如果不想读取某个键值对可以在文件内哪一行加上#注释掉，也可以用空格分隔键值对）
        FileReader fr = new FileReader("io\\44-properties.txt");
        prop.load(fr);
        System.out.println(prop.toString());//{curry=32, 马尔扎哈=33, tompthon=31}
//        FileInputStream fis = new FileInputStream("io\\44-properties.txt");
//        prop.load(fis);
//        System.out.println(prop);//{curry=32, tompthon=31, é©¬å°æå=33}
        HashSet hs = new HashSet();
        hs.add(1);
        hs.add(2);
        hs.add(1);
        hs.add("重地");
        hs.add("通话");
        System.out.println(hs);//[1, 2]
        System.out.println("重地".hashCode() + " " + "通话".hashCode());
        System.out.println(97*98*99*31);
    }
}