package com.kn20210413.file_IO.递归;

import java.io.File;
import java.util.ArrayList;

/*
构造方法不能递归
自己调用自己，有跳出条件
 */
public class DiGui {
    public static void main(String[] args) {
        //递归求和
//        Integer integer = diGuiSum(22, -24);
//        System.out.println(integer);
//        //递归遍历文件夹内的文件
//        diGuiPrint(new File("D:\\\\workspace\\\\kn-ren-test-base-001\\\\io"));
        //指定文件路径查找里面以.java结尾的文件并将文件路径添加到集合中
        ArrayList<String> list = new ArrayList<>();
        list = findFile(list, new File("D:\\\\workspace\\\\kn-ren-test-base-001\\\\io"), ".java");
        System.out.println(list);
    }

    //递归求两个数之间所有整数之和
    public static Integer diGuiSum(Integer start, Integer end) {
        if (start > end) {//如果出现第一个数比第二个数大,交换顺序
            Integer temp = 0;
            temp = start;
            start = end;
            end = temp;
        }
        Integer sum = 0;
        sum += start;
        if (start == end) {//跳出条件
            return sum;
        }
        start++;
        return sum + diGuiSum(start, end);
    }

    //递归打印文件夹及其文件的名称
    public static void diGuiPrint(File file) {
//        File file = new File("D:\\workspace\\kn-ren-test-base-001\\io");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].exists()) {
                if (files[i].isDirectory()) {
                    diGuiPrint(files[i]);
                    System.out.println(files[i]);
                }else {
                    System.out.println(files[i]);
                }
            }
        }
    }

    //递归实现指定文件夹内的文件搜索并将路径添加到集合返回集合
    public static ArrayList<String> findFile(ArrayList<String> list, File file, String fileName) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {//如果是文件夹继续递归遍历
                findFile(list, files[i], fileName);
            }else {//如果是文件判断文件名称是否是要查找的文件
                if (files[i].getName().endsWith(fileName)) {
                    String filesPath = files[i].getAbsolutePath();
                    System.out.println(filesPath);
                    list.add(filesPath);
                }
            }
        }
        return list;
    }
}
