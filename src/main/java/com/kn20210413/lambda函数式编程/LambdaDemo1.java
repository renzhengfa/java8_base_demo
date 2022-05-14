package com.kn20210413.lambda函数式编程;

/*
Lambda更多关注的是结果，是哪个对象完成这个任务是不关注的。
Lambda格式：一些参数传递给一段代码
实例：(数据类型 数据名称...) -> {一段代码}
    1、()一些参数,接口中方法参数列表。
    2、->一个箭头,传递的意思。
    3、一段代码,接口中重写方法的方法体。
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        demo01();
    }

    public static void demo01() {
        //Lambda第一种写法(创建线程并执行)
        new Thread(() -> { System.out.println(Thread.currentThread().getName() + " 线程创建了"); }).start();//Thread-0 线程创建了
        //Lambda第二种写法(创建线程并执行)
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程创建了")).start();//Thread-1 线程创建了
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 线程创建了")).start();//Thread-2 线程创建了
    }
}
