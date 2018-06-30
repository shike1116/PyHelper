package com.mao.pyhelper;

import android.app.Application;

import com.mao.baseapp.MaoConfig;

/**
 * Created by wjf on 18/6/27.
 */

public class MainApplication extends Application{

    private static MainApplication instance;

    public static MainApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MaoConfig.init(this);
    }
}
