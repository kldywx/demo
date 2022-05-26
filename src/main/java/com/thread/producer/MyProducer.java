package com.thread.producer;

import com.thread.pool.MyExecutorService;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class MyProducer {

    BlockingQueue<Runnable> queue = null;

    private BlockingQueue<Runnable> getQueue(){
        if(queue == null){
            queue = MyExecutorService.getPool().getQueue();
        }
        return queue;
    }

    public void producer(){
        this.getQueue();
        System.out.println("queue " + queue.size());

    }

}
