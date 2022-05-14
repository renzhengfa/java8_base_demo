package com.kn20210423.jdk8新特性;

/*
函数式接口
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    void get();

    //
    public static void get1(){
        System.out.println("函数式接口的静态方法");
    }

}
