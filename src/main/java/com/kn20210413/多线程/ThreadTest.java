package com.kn20210413.多线程;

/*
多线程并发：cpu高速切换执行程序。  并行：多个CPU运行多个程序。
进程：一个应用程序，进入内存的程序叫进程。
线程：线程属于进程，一个进程可以有多个线程执行多个任务。

线程调度两种方式：
    1、限时调度 ： 平均给每一个线程的使用时间。
    2、抢占式调度：优先会让优先级比较高的线程使用cpu，如果优先级一样会随机选择一个执行。（java使用的是抢占式调度）

创建多线程步骤：
第一种：（继承Thread）
    1、创建一个继承Thread的类
    2、重写Thread类的run方法（创建该线程后需要执行的代码）
    3、创建自定义继承Thread类的对象，调用start方法开启线程让线程执行run方法
第二种：（实现Runnable接口）
    1、创建一个类实现Runnable接口
    2、重写Runnable接口的run方法（编写线程任务）
    3、创建Runnable接口实现类对象
    4、创建Thread类对象，构造方法中传递（创建的Runnable实现类对象）
    5、调用Thread类中的start方法
第三种：（匿名内部类）

常用方法：
1、获取线程名称方法：Thread对象.getName();
2、设置线程名称方法：Thread对象.setName();
3、让当前线程睡眠方法：Thread.sleep(ms);单位为毫秒（静态方法）
4、开始执行线程方法：Thread对象.start();

Runnable和Thread区别：
实现Runnable接口避免了对象单继承不能去继承别的类
 */
public class ThreadTest {
    public static void main(String[] args) {
//        extendsThread();
//        implementsRunnable();
        niMingNeiBuLei();
    }

    //第一种：继承Thread方式实现多线程
    public static void extendsThread() {
        //main
        for (int i = 0; i < 7; i++) {
            System.out.println("Main Thread run:" + i);
        }
        //Thread-0
        MyThread myThread = new MyThread();
        long id = myThread.getId();
        System.out.println(id);
        //Thread-1
        MyThread myThread1 = new MyThread();
//        myThread1.setName("abc");//修改线程名称
        long id1 = myThread.getId();
        System.out.println(id1);
        myThread.start();
        myThread1.start();
        //获取线程名称
        System.out.println("MainThreadName:" + Thread.currentThread().getName());//MainThreadName:main
        System.out.println("MyThreadName:" + myThread.getName());//MyThreadName:Thread-0
        System.out.println("MyThread1Name:" + myThread1.getName());//MyThread1Name:Thread-1
    }

    //第二种：实现Runnable接口方式实现多线程
    public static void implementsRunnable() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //---------------------------------------------------
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
    }

    //第三种：匿名内部类方法实现多线程
    public static void niMingNeiBuLei() {
        //1.
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }.start();
        //2.
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }).start();
    }
}