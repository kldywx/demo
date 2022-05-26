package com.quartz;

import com.DemoTestApplication;
import com.quartz.job.FileCheckJob;
import com.quartz.schedule.SchedulerUtil;
import org.junit.jupiter.api.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoTestApplication.class)
public class QuzrtzTest {

    // 测试方法执行失败，main执行成功
    public static void main(String[] args) {
        try {
            SchedulerUtil.schedulerJob("fileCheckJob","fileCheckJobGroup",
                    "fileCheckTrigger", "fileCheckTriggerGroup",
                    "0/10 * * * * ? ", FileCheckJob.class );
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void quzrtz() {
        try {
            SchedulerUtil.schedulerJob("fileCheckJob","fileCheckJobGroup",
                    "fileCheckTrigger", "fileCheckTriggerGroup",
                    "0/10 * * * * ? ", FileCheckJob.class );
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void quzrtzStart() {
//        String jobName = "com.quartz.test.JobTest";
        String jobName = "com.quartz.test.FileCheckJob";
        try {
            SchedulerUtil.schedulerJob("job","jobGroup",
                    "trigger", "triggerGroup",
                    "0/10 * * * * ? ", (Class<? extends Job>) Class.forName(jobName));
            List<JobExecutionContext> jobList = SchedulerUtil.getScheduler().getCurrentlyExecutingJobs();
            for (JobExecutionContext job:jobList){
                System.out.println(job.toString());
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
