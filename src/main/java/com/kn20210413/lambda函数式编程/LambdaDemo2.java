package com.kn20210413.lambda函数式编程;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //常规匿名内部类写法
        cookie(new Cook() {
            @Override
            public void cookie(String name1) {
                System.out.println(name1 + "吃饭了...");
            }
        });
        //Lambda表达式写法
        cookie((String name1)->{
            System.out.println(name1 + "吃饭了...");
        });
    }

    public static void cookie(Cook cook){
        String name = "aa";
        cook.cookie(name);
    }
}