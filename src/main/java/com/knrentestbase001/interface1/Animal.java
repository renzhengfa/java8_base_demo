package com.knrentestbase001.interface1;

/*
接口内的成员变量必须有public final static修饰
 */
public interface Animal extends Interface2,Interface3 {

    //常量
    public final static String name = "arfa";

    public abstract String eat();
    public abstract String sleep();

    public static void getA(){
        System.out.println("aa");
    }

    public default void getB(){
        System.out.println("bb");
    }

    public default void method(){
        System.out.println("interface method");
    }
    //jdk9及之后支持接口内些私有化方法
//    private default void str(){
//        System.out.println("aa");
//    }

}
