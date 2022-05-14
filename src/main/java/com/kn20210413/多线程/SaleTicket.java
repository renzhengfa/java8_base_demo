package com.kn20210413.多线程;

public class SaleTicket {
    public static void main(String[] args) {
        SaleTicketRunnableImpl run = new SaleTicketRunnableImpl();
        Thread thread0 = new Thread(run);
        Thread thread1 = new Thread(run);
        Thread thread2 = new Thread(run);
        Thread thread3 = new Thread(run);
        Thread thread4 = new Thread(run);
        thread1.start();
        thread0.start();
        thread2.start();
//        thread3.start();
//        thread4.start();
        try {
            Thread.sleep(2000);
            //5个线程时14张，4个线程时13张，3个线程时12张(线程睡眠时，不睡时可能一个线程执行完所有动作)
            System.out.println(run.getCountTicket1());
            //Thread-0 正在卖第： 10 张票
            //Thread-0 正在卖第： 9 张票
            //Thread-2 正在卖第： 8 张票
            //Thread-2 正在卖第： 7 张票
            //Thread-2 正在卖第： 6 张票
            //Thread-2 正在卖第： 5 张票
            //Thread-2 正在卖第： 4 张票
            //Thread-2 正在卖第： 3 张票
            //Thread-2 正在卖第： 2 张票
            //Thread-2 正在卖第： 1 张票
            //Thread-1 正在卖第： 10 张票
            //Thread-0 正在卖第： 8 张票
            //12
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
