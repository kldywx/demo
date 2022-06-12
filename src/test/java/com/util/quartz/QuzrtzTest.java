package com.util.quartz;

import com.DemoTestApplication;
import com.util.quartz.schedule.SchedulerUtil;
import org.junit.jupiter.api.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoTestApplication.class)
public class QuzrtzTest {

    // 测试方法执行失败，main执行成功
    public static void main(String[] args) {
        String jobName1 = "com.quartz.job.JobTest";
        String jobName2 = "com.quartz.job.FileCheckJob";
        try {
            SchedulerUtil.schedulerJob("job1","jobGroup1",
                    "trigger1", "triggerGroup1",
                    "0/10 * * * * ? ", (Class<? extends Job>) Class.forName(jobName1));
            SchedulerUtil.schedulerJob("job2","jobGroup2",
                    "trigger2", "triggerGroup2",
                    "0/10 * * * * ? ", (Class<? extends Job>) Class.forName(jobName2));
            List<JobExecutionContext> jobList = SchedulerUtil.getScheduler().getCurrentlyExecutingJobs();
            for (JobExecutionContext job:jobList){
                System.out.println(job.toString());
            }

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
