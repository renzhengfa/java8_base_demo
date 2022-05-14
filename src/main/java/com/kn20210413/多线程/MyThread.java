package com.kn20210413.多线程;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " run:" + i);
        }
    }
}
