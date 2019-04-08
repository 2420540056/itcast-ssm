package com.itheima.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
/**
 * 时间转字符串
 * */
    public static String datetoString(Date date){
        SimpleDateFormat smd=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        String d = smd.format(date);
        return d;
    }
    /***
     * 字符串转时间
     * **/
    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat smf=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        Date datestr = smf.parse(date);
        return datestr;
    }
}
