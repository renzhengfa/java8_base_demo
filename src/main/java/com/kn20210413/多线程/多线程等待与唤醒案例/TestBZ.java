package com.kn20210413.多线程.多线程等待与唤醒案例;

import java.util.ArrayList;
import java.util.Iterator;

/*
包子铺线程和顾客线程应该互斥，（应该保证这两个线程只有一个线程在执行）
 */
public class TestBZ {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new BaoZiPu(baoZi).start();
        new Customer(baoZi).start();
    }
}
