package com.mao.baseapp.common.utils;

import com.google.gson.Gson;
import com.mao.baseapp.common.log.LogCore;

/**
 * 2018/6/28
 *
 * @author wangjf
 */

public class GsonUtils {
    private final static String TAG = "GSON";
    private static Gson gson = new Gson();
    public static  <T> T fromJson(String json, Class<T> classOfT){
        try {
            return gson.fromJson(json, classOfT);
        }catch (Exception e){
            LogCore.i(TAG,"json = " +json,e);
        }
        return null;
    }

    public static String toJson(Object object){
        try {
            return gson.toJson(object);
        }catch (Exception e){
            LogCore.i(TAG, e);
        }
        return null;
    }
}
