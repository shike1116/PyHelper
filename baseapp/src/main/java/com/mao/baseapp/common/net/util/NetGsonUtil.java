package com.mao.baseapp.common.net.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mao.baseapp.common.log.LogCore;
import com.mao.baseapp.common.net.dto.DetailDTO;
import com.mao.baseapp.common.net.dto.ListDTO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class NetGsonUtil {

    private static String TAG = "GSON";

    public static DetailDTO fromDetailJson(String json, Class clazz) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            Type objectType = type(DetailDTO.class, clazz);
            return gson.fromJson(json, objectType);
        }catch (Exception e){
            LogCore.i(TAG ,"json = " + json,e);
        }
        return null;
    }

    public static DetailDTO fromDetailJson2(String json, Class clazz) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm").create();
            Type objectType = type(DetailDTO.class, clazz);
            return gson.fromJson(json, objectType);
        }catch (Exception e){
            LogCore.i(TAG ,"json = " + json,e);
        }
        return null;
    }

    public static ListDTO fromListJson(String json, Class clazz) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            Type objectType = type(ListDTO.class, clazz);
            return gson.fromJson(json, objectType);
        }catch (Exception e){
            LogCore.i(TAG ,"json = " + json,e);
        }
        return null;

    }

    public static ListDTO fromListJson2(String json, Class clazz) {
        try {//yyyy年MM月dd日 HH:mm
            Gson gson = new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm").create();
            Type objectType = type(ListDTO.class, clazz);
            return gson.fromJson(json, objectType);
        }catch (Exception e){
            LogCore.i(TAG ,"json = " + json,e);
        }
        return null;
    }
    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    private static Gson gson = new Gson();
    public static  <T> T fromJson(String json, Class<T> classOfT){
        try {
            return gson.fromJson(json, classOfT);
        }catch (Exception e){
            LogCore.i(TAG ,"json = " + json,e);
        }
        return null;
    }

    public static String fromJson(Object object){
        try {
            return gson.toJson(object);
        }catch (Exception e){
            LogCore.i(TAG ,e);
        }
        return null;
    }
}
