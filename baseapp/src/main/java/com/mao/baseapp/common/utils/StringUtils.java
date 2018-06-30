package com.mao.baseapp.common.utils;

import android.text.Html;
import android.text.Spanned;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringUtils {

    public static String minutePattern = "HH:mm";
    public static String weekPattern = "EEEE";

    public static String pattern2 = "MM-dd";

    public static String pattern3 = "MM月\n dd日";


    public static String getKeDay(Date date) {
        Calendar mCurCalendar = Calendar.getInstance();
        Calendar mParCalendar = Calendar.getInstance();
        mParCalendar.setTime(date);
        int curDay = mCurCalendar.get(Calendar.DAY_OF_YEAR);
        int parDay = mParCalendar.get(Calendar.DAY_OF_YEAR);
        int diffDays = 0;
        diffDays = curDay - parDay;
        if (diffDays == 0) {
            int curHour = mCurCalendar.get(Calendar.HOUR_OF_DAY);
            int parHour = mParCalendar.get(Calendar.HOUR_OF_DAY);
            if(curHour == parHour){
                return "刚刚";
            }else{
                return curHour - parHour +"小时前";
            }
        } else {
            return diffDays + "天前";
        }
    }

    public static String getDayBig(Date date) {
        Calendar mCurCalendar = Calendar.getInstance();
        Calendar mParCalendar = Calendar.getInstance();
        mParCalendar.setTime(date);
        int curDay = mCurCalendar.get(Calendar.DAY_OF_YEAR);
        int parDay = mParCalendar.get(Calendar.DAY_OF_YEAR);
        int diffDays = 0;
        diffDays = curDay - parDay;
        if (diffDays == 0) {
            return "今天";
        } else if (diffDays == 1) {
            return "昨天";
        } else {
            String mm = parseTime(date, "MM");
            String dd = parseTime(date, "dd");
            return "<big><big><big>" +dd+ "</big></big></big>\n" + "<small>"+mm +"月</small>";
        }
    }

    public static String getTimeInDay(Date date) {
        return parseTime(date,minutePattern);
    }


    public static String parseTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(date);
    }

    public static Spanned showNameAndBB(String name,String code){
        String source = name +"    <small><font color='#999999'>  @"+code+"</font></small>";
        return Html.fromHtml(source);
    }

    public static Spanned showBigNameAndBB(String name,String code){
        String source = "<strong>" +name +"</strong>    <small><font color='#999999'>  @"+code+"</font></small>";
        return Html.fromHtml(source);
    }
}
