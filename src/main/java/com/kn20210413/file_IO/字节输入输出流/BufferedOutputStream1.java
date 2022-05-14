package com.kn20210413.file_IO.字节输入输出流;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
缓冲字节输出流
构造方法：
    1、BufferedOutputStream(OutputStream os);
    2、BufferedOutputStream(OutputStream os, int size);创建一个指定大小的缓冲流，不指定就使用默认大小
 */
public class BufferedOutputStream1 {
    public static void main(String[] args) throws IOException {
        bufferedOut1();
    }

    //使用缓冲流将数据写入文件
    public static void bufferedOut1() throws IOException {
        String str = "这是采用缓冲流BufferedOutputStream写入文件的数据。";
        //1、创建对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("io\\55-buffered.txt"));
        //2、调用BufferedOutputStream的write方法将数据写入缓冲区中
        bos.write(str.getBytes());
        //3、将缓冲区的数据刷新到文件中,释放资源close()方法会调用flush()
//        bos.flush();
        bos.close();
    }
}
