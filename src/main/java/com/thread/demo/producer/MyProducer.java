package com.thread.demo.producer;

import com.thread.demo.pool.MyExecutorService;

import java.util.concurrent.BlockingQueue;

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
