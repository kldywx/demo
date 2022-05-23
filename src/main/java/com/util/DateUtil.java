package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
