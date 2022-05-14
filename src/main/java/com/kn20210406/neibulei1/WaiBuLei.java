package com.kn20210406.neibulei1;

/*
内部类：
 */
public class WaiBuLei {

    private String name;

    public class NeiBuLei{

//        method1();
        WaiBuLei waiBuLei = new WaiBuLei();

        public void method1(){
            System.out.println("内部类方法");
        }
    }

    public void method1(){
        System.out.println("外部类方法");
        new NeiBuLei().method1();
    }

}
