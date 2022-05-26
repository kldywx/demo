package com.util;

import com.DemoTestApplication;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest(classes = DemoTestApplication.class)
public class DateUtil {

    public static void main(String[] args) {
        String year = "2021";
        String month = "06";
        String date = year+month;

        SimpleDateFormat sim = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat sim2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parse = null;
        try {
            parse = sim.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("parse = " + parse);
        System.out.println("parse = " + parse.getTime());
        String format = sim2.format(parse);
        System.out.println("format = " + format);

    }

    @Test
    public void checkData() {
        try {
            String dateString1 = "202001";
            String dateString2 = "202205";
            Date dateDate1 = new SimpleDateFormat("yyyyMM").parse(dateString1);
            Date dateDate2 = new SimpleDateFormat("yyyyMM").parse(dateString2);
            System.out.println("Year : " + (dateDate2.getYear() - dateDate1.getYear()) );
            System.out.println("Month : " + (dateDate2.getMonth() - dateDate1.getMonth()));

            Calendar dateCalendar1 = Calendar.getInstance();
            dateCalendar1.setTime(dateDate1);
            Calendar dateCalendar2 = Calendar.getInstance();
            dateCalendar2.setTime(dateDate2);
            System.out.println("Year : " +
                    (dateCalendar2.get(Calendar.YEAR) - dateCalendar1.get(Calendar.YEAR)) );
            System.out.println("Month : " +
                    (dateCalendar2.get(Calendar.MONTH) - dateCalendar1.get(Calendar.MONTH)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
