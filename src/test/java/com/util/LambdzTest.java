package com.util;

public class LambdzTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        }).start();

        //使用Lambda
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"新线程创建了");
        }).start();

        //优化lambda
        new Thread(()->System.out.println(Thread.currentThread().getName()+"新线程创建了")).start();
    }

}
