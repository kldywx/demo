package com.util.quartz.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class Queue {

    /** 作为双端队列（两端可进出） */
    private Deque deque = null;

    public Deque getDeque(){
        if (deque == null){
            deque = new LinkedList();
        }
        return deque;
    }

    public boolean clearDeque(){
        if (deque == null){
            deque.clear();
        }
        return true;
    }

    /** 添加元素 超出容量时返回false */
    public <E> boolean offerLast(E e){
        return deque.offerLast(e);
    }

    /** 删除元素 容量=0时返回false */
    public <E> Object pollLast(){
        return (E) deque.pollLast();
    }

    /** 获取元素 容量=0时返回false */
    public <E> Object peekFirst(){
        return deque.peekFirst();
    }

}
