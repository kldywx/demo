package com.thread.demo.pool;

import java.util.concurrent.*;

public class MyExecutorService {

    /**
     * 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
     */
    private static int corePoolSize = 5;

    /**
     * 线程数的上限
     */
    private static int maximumPoolSize = 10;

    /**
     * 超过corePoolSize的线程的idle时长，超过这个时间，多余的线程会被回收。
     */
    private static long keepAliveTime;

    private static TimeUnit unit;

    /**
     * 任务的排队队列
     */
    private static BlockingQueue<Runnable> workQueue;

    /**
     * 新线程的产生方式
     */
    private static ThreadFactory threadFactory;

    /**
     * 拒绝策略
     */
    private static RejectedExecutionHandler handler;

    /**
     * 线程池
     */
    private static ThreadPoolExecutor pool = null;

    /**
     * 获取线程池
     */
    public static ThreadPoolExecutor getPool(){
        if(pool == null){
            /**
             * 最大线程等于最小线程数，不会扩张，不存在线程释放
             * 使用无界队列，任务可以无限放入，
             * 当请求过多时可能导致占用过多内存或直接导致OOM异常
             */
            pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(corePoolSize);
        }
        return pool;
    }

    /**
     * 关闭线程池
     */
    public static void closePool(){
        if(pool != null){
            /**
             * 平滑关闭线程池，
             * 正在执行中的及队列中的任务能执行完成，
             * 后续进来的任务会被执行拒绝策略
             */
            pool.shutdown();
        }
    }


}
