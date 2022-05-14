package com.kn20210413.多线程.多线程等待与唤醒案例;

/*
包子铺线程对象
 */
public class BaoZiPu extends Thread {

    //包子对象
    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        //让包子铺一直生产包子
        synchronized (bz) {
            Thread.currentThread().setName("BaoZiPu");
            while (true) {
                if (bz.getHave()) {
                    System.out.println(Thread.currentThread().getName() + " 3.包子铺有包子，老板休息...");
                    try {
                        bz.wait();//生产包子线程进入永久休眠(休眠后后面的代码会等待顾客线程唤醒了才会执行)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 1.包子铺没有包子，老板做包子...");
                try {
                    Thread.currentThread().sleep(4000);//包子铺生产包子
                    bz.setHave(true);
                    System.out.println(Thread.currentThread().getName() + " 2.包子铺已经生产好包子...");
                    //唤醒顾客线程吃包子(准备CPU抢占)
                    bz.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
