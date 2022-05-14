package com.kn20210413.file_IO.字符输入输出流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
抽象类：
字符输出流java.io.Writer
基本方法：
    1、write（...）
    2、flush();刷新缓冲区数据到文件，之后可以继续用该流
    3、close();关闭后流不可用
 */
public class FileWriter1 {
    public static void main(String[] args) throws IOException {
        fileWriter1();
    }

    //用
    public static void fileWriter1() throws IOException {
        FileReader fr = new FileReader("io\\33-reader.txt");
//        FileWriter fw = new FileWriter("io\\33-writer.txt");
        FileWriter fw = new FileWriter("io\\33-writer.txt",true);
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars, 0, len);//将读取的数据写入到内存缓冲区中
            System.out.println("len: " + len);
            System.out.println("chars: " + chars);
            System.out.println(new String(chars, 0, len));
            fw.flush();//flush是将缓冲区的数据刷新到文件之后流可以继续使用，但是close后流就不可以用了
        }
//        fw.write("Hello , curry ,you are ...");
//        fw.flush();
        fw.close();
        fr.close();
    }
}
