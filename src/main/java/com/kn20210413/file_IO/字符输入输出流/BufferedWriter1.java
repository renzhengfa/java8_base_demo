package com.kn20210413.file_IO.字符输入输出流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
缓冲字符输出流
 */
public class BufferedWriter1 {
    public static void main(String[] args) throws IOException {
        buffWrite();
    }

    //使用BufferedWriter缓冲字符输入流写数据到文件
    public static void buffWrite() throws IOException {
        //1、创建缓冲流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("io\\66-buffered-char.txt"));
        //2、使用缓冲流写数据
        bw.write("line1:这是使用BufferedWriter缓冲字符写入流写入的数据\r\nline2:这是第二行。！！！");
        //3、将缓冲流里面的数据刷新到文件内
        bw.flush();
        //4、释放资源
        bw.close();
    }
}
