package com.kn20210406.neibulei1;

/*
成员内部类使用方法
1.间接方式：通过外部类方法调用内部类方法的方式使用内部类
2.直接方式：【外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();】
 */
public class NeiBuleitest {

    public static void main(String[] args) {
        WaiBuLei waiBuLei = new WaiBuLei();
        //1.通过外部类方法调用内部类方法的方式使用内部类
        waiBuLei.method1(); //外部类方法
                            //内部类方法
        //2.直接方式：
        WaiBuLei.NeiBuLei neiBuLei = new WaiBuLei().new NeiBuLei();
        neiBuLei.method1();//内部类方法
    }

}
