package com.kn20210413.file_IO.转换流;

import java.io.*;

/*
输入转换流InputStreamReader
构造方法：
    1、InputStreamReader(InputStream in);
    2、InputStreamReader(InputStream in, String charsetName);指定字符集
 */
public class InputStreamReader1 {
    public static void main(String[] args) throws IOException {
        read();
    }

    //输入转换流指定格式读取文件数据
    public static void read() throws IOException {
        //指定字符集为UTF-8来读取文件内容，当文件字符集和指定字符集相同时才不会出现乱码
        InputStreamReader isr1 = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\utf8.txt"),"UTF-8");
//        InputStreamReader isr1 = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\else.txt"),"UTF-8");
//        InputStreamReader isr1 = new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\UTF-16 LE.txt"),"UTF-16");
        int len = 0;
        char[] bytes = new char[1024];
        while ((len = isr1.read(bytes)) != -1) {
            System.out.println(bytes);
        }
        isr1.close();
    }
}

/*
输出转换流OutputStreamWriter
构造方法：
    1、OutputStreamWriter(OutputStream in);
    2、OutputStreamWriter(OutputStream in, String charsetName);指定字符集写你想写的编码字符集
 */
class OutputStreamWriter1{
    public static void write() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("file-path"),"UTF-8");
        osw.write("aas");
        osw.close();
    }
}