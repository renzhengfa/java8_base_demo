package com.knrentestbase001.mianxiangObject1;


import com.knrentestbase001.mianxiangObject.Dog;

public class Student {

    public static void main(String[] args) {
        Dog dog = new Dog();
        met(dog);
    }

    public static void met(Dog dog){
        dog.name = "wang cai";              //Dog类不重写toString方法时
        System.out.println(dog.toString()); //com.knrentestbase001.mianxiangObject.Dog@2f2c9b19
        System.out.println(dog.name);       //wang cai
        int a;
        char aa = '2';
        char bb = '2';
        System.out.println(aa % bb); // 97
//        System.out.println(a);
    }

}
