package com.kn20210413.多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池：LinkedList<Thread>

java.util.concurrent.Executors：
    newFixedThreadPool(Integer 线程数);线程池工厂类静态方法
java.util.concurrent.ExecutorService：
    submit(Runnable task)提交一个Runnable任务用于执行
    void shutdown() 关闭/销毁线程池的方法

使用线程池方法步骤：
1、使用线程池工厂类Executors调用起静态方法newFixedThreadPool(Integer 线程数)生产一个指定数量线程的线程池。
2、写一个类,实现Runnable接口并重写run方法,编写线程任务。
3、调用ExecutorService executorService中的submit(Runnable)方法,传递线程任务,开启线程,执行run方法。
4、调用ExecutorService executorService中的shutdown()方法用于销毁线程（不建议使用,线程应该使用后放回线程池,而不是销毁线程）
 */
public class Executors线程池工厂类 {
    public static void main(String[] args) {
        //1、创建一个包含2个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //3、
        executorService.submit(new MyThread());
        executorService.submit(new MyThread());
        executorService.submit(new MyThread());
        //4、
        executorService.shutdown();//销毁线程池
//        executorService.submit(new MyThread());//销毁后在执行会报错java.util.concurrent.RejectedExecutionException
    }
}

//2、创建Runnable实现类，重写run方法并编写线程任务
class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在执行...");
    }
}