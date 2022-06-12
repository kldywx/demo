package com.util.quartz.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 任务调度工具
 *
 * @author Xu
 * @date 2022/05/01
 */
public class SchedulerUtil {

    private static SchedulerFactory schedulerFactory = null;
    private static Scheduler scheduler = null;

    /** 创建调度器 */
    public static Scheduler getScheduler() throws SchedulerException {
        if(schedulerFactory == null){
            schedulerFactory = new StdSchedulerFactory();
            scheduler = schedulerFactory.getScheduler();
        }else if (scheduler == null){
            scheduler = schedulerFactory.getScheduler();
        }
        return scheduler;
    }

    public static void schedulerJob(String jobName, String jobGroup, String triggerName,
                                    String triggerGroup, String cron, Class<? extends Job> jobClass
    ) {
        // Trigger 和 Job 存储在内存中
        /** 创建任务 */
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
        /** 创建触发器 */
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        /** 创建调度器 */
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
            /** 任务监听 ？ 触发器监听 */

            /** 将任务及其触发器放入调度器 */
            scheduler.scheduleJob(jobDetail, trigger);
            /** 调度器开始调度任务 */
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        /** 调度类启动的线程 调度线程？ */

        /** 执行器 ？ */

//        Quartz的集群部署方案，需要针对不同的数据库类型(MySQL , ORACLE) 在数据库实例上创建Quartz表，
//        JobStore是: JobStoreSupport。
//        这种方案是分布式的，没有负责集中管理的节点，而是利用数据库行级锁的方式来实现集群环境下的并发控制。

//        电商场景 高并发 订单支付检查 Redis 分布式锁

    }

}
