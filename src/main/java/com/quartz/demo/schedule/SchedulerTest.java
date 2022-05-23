package com.quartz.demo.schedule;

import com.quartz.test.JobTest;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 测试任务调度，并执行 demo
 *
 * @author Xu
 * @date 2022/05/01
 */
public class SchedulerTest {

    /**
     * 创建调度器
     */
    public static Scheduler getScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }

    public static void schedulerJob() throws SchedulerException {
        /**
         * 创建任务
         */
        JobDetail jobDetail = JobBuilder.newJob(JobTest.class).withIdentity("job1", "group1").build();
        /**
         * 创建触发器
         */
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group3")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? "))
                .build();
        Scheduler scheduler = getScheduler();
        /**
         * 将任务及其触发器放入调度器
         */
        scheduler.scheduleJob(jobDetail, trigger);
        /**
         * 调度器开始调度任务
         */
        scheduler.start();
    }

    public static void schedulerJob(String jobName, String jobGroup,
                                    String triggerName, String triggerGroup,
                                    String cron, Class<? extends Job> jobClass
    ) throws SchedulerException {
        /**
         * 创建任务
         */
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
        /**
         * 创建触发器
         */
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        /**
         * 创建调度器
         */
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        /**
         * 将任务及其触发器放入调度器
         */
        scheduler.scheduleJob(jobDetail, trigger);
        /**
         * 调度器开始调度任务
         */
        scheduler.start();
    }

}
