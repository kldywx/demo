package com.quartz.test;

import com.DemoTestApplication;
import com.quartz.demo.schedule.SchedulerTest;
import org.junit.jupiter.api.Test;
import org.quartz.Job;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoTestApplication.class)
public class QuzrtzTest {

    @Test
    public void quzrtzStart() {
//        String jobName = "com.quartz.test.JobTest";
        String jobName = "com.quartz.test.FileCheckJob";
        try {
            SchedulerTest.schedulerJob("job","jobGroup",
                    "trigger", "triggerGroup",
                    "0/10 * * * * ? ", (Class<? extends Job>) Class.forName(jobName));
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
