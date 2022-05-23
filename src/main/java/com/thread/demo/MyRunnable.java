package com.thread.demo;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("启动线程 MyRunnable");
    }

}
