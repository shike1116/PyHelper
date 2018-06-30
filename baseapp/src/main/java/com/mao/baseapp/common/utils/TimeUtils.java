package com.mao.baseapp.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String  getCurrentFormatYMD(){
        SimpleDateFormat df = new SimpleDateFormat("MM_dd_");//设置日期格式
        return df.format(new Date());
    }

    public static String  getCurrentFormatHMSS(){
        return "";
    }

    public static String  getCurrentFormatYMDHMSS(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());

    }


}
