package com.kn20210413.file_IO.字节输入输出流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
字节输入流:FileInputStream
构造方法：FileInputStream(File file);FileInputStream(String path);
主要方法：read();read(byte[] b);read(byte[] b,int off,int len);close();
1个中文字符：使用GBK编码占用2个字节，使用UTF-8编码占用3个字节
 */
public class FileInputStream1 {
    public static void main(String[] args) throws IOException {
        inputStream1();
    }

    //读取文件内容写入指定文件（文件复制）
    public static void inputStream1() throws IOException {
        FileInputStream fis = new FileInputStream("io\\22.txt");
        FileOutputStream fos = new FileOutputStream("io\\22-备份.txt");
        //获取读取数据
        byte[] bytes = new byte[1024];
        int len = 0;//返回读取bytes数组读取有效长度，同时将读取的字节添加到字节数组
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(Arrays.toString(bytes));//[-26, -126, -88, -27, -91, -67, -17, -68, -127, -17, -68, -127, -17, -68, -127, 0, 0...]
            System.out.println(bytes.length);//1024
            System.out.println(new String(bytes));//您好！！！
            System.out.println(len);//15   UTF-8格式
            fos.write(bytes,0, len);//写如文件，从索引为0开始，写入索引0后面的len个字节
        }
        fos.close();//写完了肯定读完了所以先关写的流
        fis.close();
    }
}
