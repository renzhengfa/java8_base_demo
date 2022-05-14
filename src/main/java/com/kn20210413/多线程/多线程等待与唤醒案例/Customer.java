package com.kn20210413.多线程.多线程等待与唤醒案例;

/*
顾客类
 */
public class Customer extends Thread {

    //包子对象
    private BaoZi bz;

    public Customer(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        //一直有人来吃包子
        synchronized (bz) {
            Thread.currentThread().setName("Customer");
            while (true){
                if (!bz.getHave()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 5.包子铺没有包子，顾客通知老板做包子...");
                        bz.wait();//顾客线程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 4.老板做好包子，顾客开始吃包子，并吃完包子...");
                bz.setHave(false);//
                System.out.println("--------------------------------");
                bz.notify();//唤醒包子铺线程(准备CPU抢占)
            }
        }
    }
}
