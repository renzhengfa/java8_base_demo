package com.kn20210413.file_IO.字符输入输出流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/*
缓冲字符输入流
 */
public class BufferedReader1 {
    public static void main(String[] args) throws IOException {
        bufferedRead();
    }

    //使用字符缓冲输入流读取数据
    public static void bufferedRead() throws IOException {
        //1、创建对象
        BufferedReader br = new BufferedReader(new FileReader("io\\66-buffered-char.txt"));
        //2、读取数据
        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
//        char[] chars = new char[1024];
//        int len = 0;//获取有效读取字符个数
//        while ((len = br.read(chars)) != -1) {
//            System.out.println(new String(chars,0,len));
//        }
        //3、释放资源
        br.close();
    }
}
