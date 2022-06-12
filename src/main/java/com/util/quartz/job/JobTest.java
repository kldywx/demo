package com.util.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试任务 demo
 *
 * @author Xu
 * @date 2022/05/01
 */
public class JobTest implements Job {

    private Logger log = LoggerFactory.getLogger(JobTest.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("测试 ： 执行");
    }
}
