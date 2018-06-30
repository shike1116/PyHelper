package com.mao.baseapp.common.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "shp";

    private static Application application;

    public static void init(Application app){
        application = app;
    }
    public static boolean commitInt(String key, int value){
        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean commitString(String key, String value){

        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean commitLong(String key, long value){

        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static boolean commitBoolean(String key, boolean value){
        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean commitFloat(String key, float value){

        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public static String getString(String key, String defValue) {
        if(application == null){
            return null;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        if(application == null){
            return 0L;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }

    /**
     * 移除某个key值已经对应的值
     * @param key
     */
    public static void remove(String key) {
        if(application == null){
            return ;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
     */
    public static void clearAll(){
        if(application == null){
            return ;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 查询某个key是否已经存在
     * @param key
     * @return
     */
    public static boolean contains(String key){
        if(application == null){
            return false;
        }
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

}
