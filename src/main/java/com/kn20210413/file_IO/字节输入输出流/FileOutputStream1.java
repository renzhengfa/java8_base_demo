package com.kn20210413.file_IO.字节输入输出流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
FileOutputStream:输出流（将内存里面的数据往硬盘里面写）
ASCII码表（0-127）如果字节的二进制不在这个范围将查询操作系统默认的码表（GBK）
 */
public class FileOutputStream1 {
    public static void main(String[] args) throws IOException {
//        output1();
        output2();
    }

    //不追加写（每次写都会覆盖前面写的内容）
    public static void output1() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("io\\11.txt");
            fos.write(98);//FileOutputStream.write(int i)写入单个字节
            //ASCII码表（0-127）如果字节的二进制不在这个范围将查询操作系统默认的码表（GBK）
            //FileOutputStream.write(byte[] b)写入多个字节
            fos.write(new byte[]{'a','b',48});
            //写字节数组的一部分FileOutputStream.write(byte[] b, int off, int len)off为开始索引,len为长度。
            byte[] bytes = new byte[]{'a',98,99,100};
            fos.write(bytes, 0,2);//ab
            String hello = "您好！！！";
            byte[] h = hello.getBytes();
            System.out.println(Arrays.toString(h));//[-26, -126, -88, -27, -91, -67, -17, -68, -127, -17, -68, -127, -17, -68, -127]
            fos.write(h,0,h.length);//您好！！！
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //释放资源
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //追加写（每次写都不会覆盖前面写的内容）
    public static void output2() throws IOException {
        FileOutputStream fos = new FileOutputStream("io\\22.txt",true);
        for (int i = 0; i < 10; i++) {
            String hello = "您好！！！\r\n";//换行符Windows：\r\n linux:/n mac:/r
            fos.write(hello.getBytes());
        }
        fos.close();
    }
}
