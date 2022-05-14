package com.kn20210413.file_IO.打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
打印流设置输出位置
System.setOut(PrintStream ps);
 */
public class PrintStream1 {
    public static void main(String[] args) throws FileNotFoundException {
        print();
    }

    //调整打印输出位置
    public static void print() throws FileNotFoundException {
        PrintStream ps = new PrintStream("io\\99-打印流.txt");
        System.setOut(ps);
        System.out.println(8.8);
        System.out.println(11);
        System.out.println(true);
        System.out.println("java");
        ps.close();
    }
}
