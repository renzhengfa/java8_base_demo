package com.kn20210413.file_IO.字符输入输出流;

import java.io.FileReader;
import java.io.IOException;

/*
父类:java.io.Reader
主要方法：
    1、int read();读取单个字符
    2、int read(char[] buf);读取多个字符
    3、void close();关闭该流并释放所有与之相关的资源
FileReader:构造方法
    1、FileReader(String path)path为文件路径 2、FileReader(File file)
 */
public class FileReader1 {
    public static void main(String[] args) throws IOException {
        fileReader1();
    }

    //将硬盘内的文件以字符的形式读取到内存中
    public static void fileReader1() throws IOException {
        FileReader fr = new FileReader("io\\33-reader.txt");
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        fr.close();//释放资源
    }
}
