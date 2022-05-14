package com.kn20210413.多线程;

/*
线程状态：6种（新建、执行、阻塞、休眠sleep、无限休眠wait、死亡）
1、wait()或wait(Long long好多毫秒内没有被notify唤醒自动唤醒)的线程需要notify()来唤醒线程，但是sleep()是到了时间自己醒过来。notifyAll()
2、
 */
public class 线程状态 extends Thread {

    public static void main(String[] args) {
        Object obj = new Object();
        buyBaoZi(obj);
        saleBaoZi(obj);
//        SaleTicket saleTicket = new SaleTicket();
//        buyBaoZi(saleTicket);
//        saleBaoZi(saleTicket);
        System.out.println(30.69+8+321.44);
    }

    //卖baozi
//    public static void saleBaoZi(SaleTicket obj) {
    public static void saleBaoZi(Object obj) {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        this.setName("老板");
                        System.out.println("线程：" + Thread.currentThread().getName() + " 老板得到需求开始做包子...");
                        try {
                            Thread.sleep(4000);//老板花时间做包子
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程：" + Thread.currentThread().getName() + " 老板做好包子叫顾客吃包子...");
                        obj.notify();//唤醒单个锁对象的线程（顾客线程）,继续执行吃包子代码(唤醒顾客线程后在和老板线程一起抢占cpu)
                        System.out.println("----------------------------------------------");
                    }
                }
            }
        }.start();
    }

    //买baozi
//    public static void buyBaoZi(SaleTicket obj) {
    public static void buyBaoZi(Object obj) {
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        this.setName("顾客");
                        System.out.println("线程：" + Thread.currentThread().getName() + " 顾客告诉老板需求...");
                        //告诉老板后进入等待状态
                        try {
                            obj.wait();//让顾客线程永久睡下去
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //老板做好包子，吃包子
                        System.out.println("线程：" + Thread.currentThread().getName() + " 顾客吃包子...");
                    }
                }
            }
        }.start();
    }
}