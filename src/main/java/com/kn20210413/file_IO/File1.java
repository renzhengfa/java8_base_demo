package com.kn20210413.file_IO;

import java.io.File;
import java.io.IOException;

/*
File file = new File(文件路径);
文件路径存在与否都可以。
 */
public class File1 {
    public static void main(String[] args) {
        //获取操作系统分隔符
        getCaoZuoXiTongFenGeFu();
        getFilePath();
    }

    //静态成员变量，获取操作系统分隔符
    public static void getCaoZuoXiTongFenGeFu() {
        //获取操作系统的路径分隔符（Linux为冒号:,Windows为分号;。）
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//;
        //获取操作系统的文件路径分隔符（Linux为正斜杠/,Windows为反斜杠\。）
        String separator = File.separator;
        System.out.println(separator);//\
    }

    //获取文件路径
    public static void getFilePath() {
        File file = new File("a.txt");
        String fileAbsolutePath = file.getAbsolutePath();
        System.out.println(fileAbsolutePath);//D:\workspace\kn-ren-test-base-001\a.txt
        //获取文件路径末尾的部分
        String fileName = file.getName();
        System.out.println(fileName);//a.txt

        File file1 = new File("aaa");
        String file1Name = file1.getName();
        System.out.println(file1Name);//aaa

        File file2 = new File("io\\1.jpg");
        System.out.println(file2.exists());//true
        System.out.println(file2.length());//26356

        /*
        boolean delete()删除此文件或文件夹
        boolean createNewFile()当且仅当该文件不存在时创建一个空文件,如果文件夹路径不存在会报错
        boolean mkdir()只能创建单级空文件夹
        boolean mkdirs()可以创建多级空文件夹
         */
        File file3 = new File("io\\a.txt");
        File file4 = new File("io\\aaa\\aa\\cc");
        file4.mkdirs();
        if (!file3.exists()){
            try {
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file5 = new File("io");
        System.out.println(file5.listFiles().length);//3
        System.out.println(file5.list().length);//3
        for (String s : file5.list()) {
            System.out.println(s);
        }
    }
}
