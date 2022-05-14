package com.knrentestbase001.scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scanner1 {

    public static void main(String[] args) throws FileNotFoundException {

        //系统输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int类型的值：");
        int a = sc.nextInt();
        System.out.println("int: " + a);
        System.out.println("====================");

        //从文件内读取数据
        Scanner sc1 = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\scanner.txt"));
        String str1 = sc1.next();
        System.out.println(str1);
        String b = sc1.next();
        System.out.println(b);
        int i = sc1.nextInt();
        System.out.println(i);
    }

}
