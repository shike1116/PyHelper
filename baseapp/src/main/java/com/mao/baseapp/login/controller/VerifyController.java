package com.mao.baseapp.login.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.mao.baseapp.login.model.LoginModel;


public class VerifyController {
    public int delayMillis = 2000;//时间

    public void start(final Activity activity,final Class<?> loginActivity, final Class<?> mainActivity){
        final boolean hasLogined = LoginModel.checkHasLogined();
        if(hasLogined){
            LoginModel.autoLogin(null);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(hasLogined){
                    Intent intent = new Intent(activity, mainActivity);
                    activity.startActivity(intent);
                }else {
                    Intent intent = new Intent(activity, loginActivity);
                    activity.startActivity(intent);
                }
                activity.finish();
            }
        },delayMillis);
    }
}
