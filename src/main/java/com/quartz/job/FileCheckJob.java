package com.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件检查任务
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class FileCheckJob implements Job {

    private static Logger log = LoggerFactory.getLogger(FileCheckJob.class);

    private static String filePath = "C:\\Users\\JK\\Desktop";

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /**
         * 获取当前时间精确到毫秒级的时间戳
         */
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = sdf.parse(sdf.format(startTime));
            log.debug("开始时间 : " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        log.debug("filePath : " + filePath);

        File file = new File(filePath);
        getAllFilePath(file);

        /**
         * 获取当前时间精确到毫秒级的时间戳
         */
        long endTime = System.currentTimeMillis();
        log.debug("运行时间（单位：毫秒） : " + (endTime - startTime) );
    }

    private static void getAllFilePath(File file){
        File[] fileArray = file.listFiles();
        if(fileArray != null){
            for(File oneFile : fileArray){
                if(oneFile.isDirectory()){
                    getAllFilePath(oneFile);
                }else {
                    log.debug("fileName : " + oneFile.getName());
//                    log.debug(oneFile.getPath() + " : " + oneFile.getName());
                }
            }
        }

    }

}
