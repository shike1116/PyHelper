package com.mao.baseapp;


import android.app.Application;
import android.content.SharedPreferences;

import com.mao.baseapp.common.log.MaoErrorHandler;
import com.mao.baseapp.common.utils.*;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MaoConfig {
    public static final boolean DEBUG = true;

    public static final String APP_NAME = "PyHelper";

    public static String getUserInfo(){
        return "wangjf";
    }

    public static void init(Application application){
        SPUtils.init(application);
        Thread.setDefaultUncaughtExceptionHandler(new MaoErrorHandler());
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(application));
    }

}
