package com.kn20210413.file_IO.转换流;

import java.io.*;

/*
将文件的UTF-8编码格式转换为GBK
 */
public class 转换字符编码 {
    public static void main(String[] args) throws IOException {
//        parseToGBK();
        parseToUTF_8();
    }

    //从UTF-8转换为GBK
    public static void parseToGBK() throws IOException {
        //获取对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("io\\77-转换流前UTF-8.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("io\\77-转换流后GBK.txt"),"GBK");

        //
        int len = 0;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0 , len);
        }
        osw.flush();
        //释放资源
        osw.close();
        isr.close();
    }

    //从GBK转换为UTF-8
    public static void parseToUTF_8() throws IOException {
        //获取对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("io\\77-转换流后GBK.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("io\\88-转换流后UTF-8.txt"),"UTF-8");
        //
        int len = 0;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0 , len);
        }
        osw.flush();
        //释放资源
        osw.close();
        isr.close();
    }
}
