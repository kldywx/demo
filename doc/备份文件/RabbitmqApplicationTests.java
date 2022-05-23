package com.rabbitmq.demo.test;

import com.rabbitmq.demo.sender.AmqpSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private AmqpSender sender;

    @Test
    public void testSimpleSend() {
        //简单模式发送
        for (int i = 1; i < 6; i++) {
            this.sender.simpleSend("test simpleSend " + i);
        }
    }

    @Test
    public void testPsSend() {
        //发布/订阅模式发送
        for (int i = 1; i < 6; i++) {
            this.sender.psSend("test psSend " + i);
        }
    }

    @Test
    public void testRoutingSend() {
        //路由模式发送
        for (int i = 1; i < 6; i++) {
            this.sender.routingSend("order", "test routingSend " + i);
        }
    }

    @Test
    public void testTopicSend() {
        //主题模式发送
        for (int i = 1; i < 6; i++) {
            this.sender.topicSend("user.add", "test topicSend " + i);
        }
    }

}
