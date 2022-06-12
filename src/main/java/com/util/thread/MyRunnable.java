package com.util.thread;

/**
 * 任务
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("启动线程 MyRunnable");
    }

}
