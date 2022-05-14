package com.kn20210413.file_IO;

import java.io.*;
import java.util.HashMap;

/*
普通字符字节流和缓冲字符字节流复制文件耗时比较
 */
public class 复制文件效率比较 {
    public static void main(String[] args) throws IOException {
//        Long time1 = biJiao();
//        System.out.println(time1);
        paixu();
    }

    //使用普通字节流和缓冲字节流比较复制文件速率（复制一个17M文件一般在80ms左右）
    private static Long biJiao() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\aaaa\\2-高级\\01-常用API_1\\第5节 String类\\1_3_5_01_字符串概述和特点.avi");
        FileOutputStream fos = new FileOutputStream("D:\\aa-fileInput.avi");
        int len = 0;
        byte[] bytes = new byte[2048];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
//            fos.flush();
        }
        fos.close();
        fis.close();
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    //使用缓冲流（复制一个17M文件一般在40ms左右）
    private static Long biJiaoZiFu() throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\aaaa\\2-高级\\01-常用API_1\\第5节 String类\\1_3_5_01_字符串概述和特点.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\aa-fileInput.avi"));
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }

    //
    public static void paixu(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("10","huiahuigbdua");
        hashMap.put("8","uhguihaishfucnh");
        hashMap.put("9","huiahuisasfc");
        hashMap.put("7","huiahuigbdua");
        hashMap.put("1","uhguihaishfucnh");
        hashMap.put("2","huiahuisasfc");
        hashMap.put("3","huiahuisasfc");
        System.out.println(hashMap);
        //{1=uhguihaishfucnh, 2=huiahuisasfc, 3=huiahuisasfc, 7=huiahuigbdua, 8=uhguihaishfucnh, 9=huiahuisasfc, 10=huiahuigbdua}
    }
}
