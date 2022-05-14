package com.kn20210413.多线程;

//实现Runnable接口方式创建多线程
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0 ; i < 6 ; i++) {
            try {
                Thread.sleep(1000);//睡1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
