package com.kn20210423.注解.simpleTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleTest {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        //1.获取对象
        Source1 source1 = new Source1();
        //2.获取字节码文件
        Class<Source1> clazz = (Class<Source1>) source1.getClass();
        //3.获取所有方法
        Method[] methods = clazz.getDeclaredMethods();
        //4.遍历方法判断方法是否加了注解
        Integer count = 0; //计算异常出现次数
        BufferedWriter fw = new BufferedWriter(new FileWriter("io\\check\\check.txt"));//写文件的流
        for (int i = 0; i < methods.length; i++) {
//            if (methods[i].isAnnotationPresent(Check.class)){
            //判断方法前面是否加了自定义的Check注解
            if (methods[i].isAnnotationPresent(Check.class)){
                //5.执行方法
                try{
                    methods[i].invoke(source1);
                }catch (Exception e){
                    //6.捕获异常,写入文件
                    fw.newLine();
                    fw.write(methods[i].getName() + " 方法出现异常了");
                    fw.newLine();
                    fw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    fw.newLine();
                    fw.write("异常原因：" + e.getCause().getMessage());
                    fw.newLine();
                    fw.write("---------------------------------------------");
                    count++;
                }
            }
        }
        fw.newLine();
        fw.write("本次测试一共出现 " + count + " 次异常");
        //7.释放资源
        fw.flush();
        fw.close();
    }
}
