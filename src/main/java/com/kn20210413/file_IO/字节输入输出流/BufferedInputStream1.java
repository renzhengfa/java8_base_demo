package com.kn20210413.file_IO.字节输入输出流;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
缓冲字节输入流
构造方法：
    1、BufferedInputStream(InputStream os);
    2、BufferedInputStream(InputStream os, int size);创建一个指定大小的缓冲流，不指定就使用默认大小
 */
public class BufferedInputStream1 {
    public static void main(String[] args) throws IOException {
        bufferedInput1();
    }

    //使用BufferedInputStream缓冲输入流读取数据
    public static void bufferedInput1 () throws IOException {
        //1、创建对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("io\\55-buffered.txt"));
        //2、读取文件数据
        int len = 0;//读取的有效字节个数
        //存储读取数据的数组
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
            System.out.println(len);
        }
        //3、刷新数据
        bis.close();
    }
}
