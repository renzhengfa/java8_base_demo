package com.kn20210413.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
实现多线程售票场景
多线程安全解决方案：
一、同步代码块：synchronized (锁对象) {可能会出现线程安全的代码（访问了共享数据的代码）}
二、同步方法锁：public synchronized void run1() {可能出现线程安全问题代码块}
三、Lock锁接口：void lock()获取锁,void unlock()释放锁;
    1.创建Lock实现类对象：java.util.concurrent.locks.ReentrantLock implements Lock
    2.在可能出现线程安全的代码块前面获取锁：lock.lock()
    3.在可能出现线程安全的代码块后面调用unlock()释放锁（一般写在finally里面,好处是程序无论是否出现异常锁都会被释放）。
 */
public class SaleTicketRunnableImpl implements Runnable {

    //定义共享的10张票
    private static Integer countTicket = 10;
    private static Integer countTicket1 = 0;
    static Lock reentrantLock = new ReentrantLock();

    //1、同步代码块
    @Override
    public void run() {
//        synchronized (this) {
//            while (countTicket > 0) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " 正在卖第： " + countTicket + " 张票");
//                countTicket--;
//                countTicket1++;
//            }
//        }
//        run1();
        run2();
    }

    //2、同步方法锁
    public static synchronized void run1() {
        while (countTicket > 0) {
            try {
                Thread.sleep(100);
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 正在卖第： " + countTicket + " 张票");
            countTicket--;
            countTicket1++;
        }
    }

    //3、Lock锁（ReentrantLock）
    public static void run2() {
        while (true) {
            reentrantLock.lock();//获取锁
            try {
                if (countTicket > 0){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " 正在卖第： " + countTicket + " 张票");
                    countTicket--;
                    countTicket1++;
                }else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();//释放锁 (放在finally代码块中，无论怎么样都会释放锁，提高程序效率)
            }
        }
    }

    public Integer getCountTicket1() {
        return countTicket1;
    }

    public void setCountTicket1(Integer countTicket1) {
        this.countTicket1 = countTicket1;
    }
}
