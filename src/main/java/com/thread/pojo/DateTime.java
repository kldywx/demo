package com.thread.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间 POJO
 *
 * @author 许文博
 * @date 2022/5/01 10:00
 */
public class DateTime {

    private Date date;

    /** 时间戳 */
    private Long timestamp;

    private String time;

    public DateTime() {
        this.date = new Date();
        this.timestamp = date.getTime();
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
