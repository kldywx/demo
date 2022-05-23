package com.thread.test;

import com.DemoTestApplication;
import com.thread.demo.pool.MyExecutorService;
import com.thread.demo.MyCallable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.concurrent.*;

@SpringBootTest(classes = DemoTestApplication.class)
public class CallableTest {

    @Test
    public void callableTest() {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        ThreadPoolExecutor pool = MyExecutorService.getPool();
        System.out.println("pool " + pool.getQueue().size());

        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // 从Future对象上获取任务的返回值，并输出到控制台
            try {
                System.out.println(">>>" + f.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        pool.shutdown();

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");

    }

}
