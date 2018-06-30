package com.mao.baseapp.update.controller;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.mao.baseapp.base.action.LoadingAction;
import com.mao.baseapp.common.log.LogCore;
import com.mao.baseapp.common.net.rest.BizListener;
import com.mao.baseapp.update.UpdateAPI;
import com.mao.baseapp.update.entity.UpdatePo;
import com.mao.baseapp.update.ui.UpdateDialog;

/**
 * 2018/6/29
 *
 * @author wangjf
 */

public class UpdateController {
    private static final String TAG = "UpdateController";
    public void startCheck( final LoadingAction.Callback callback){
        UpdateAPI.checkUpdate(new BizListener<UpdatePo>() {
            @Override
            public void onSuccess(UpdatePo data) {
                if (callback.isDestroy()) {
                    return;
                }
                if (compareVersion(data.versions, getCurrentVersionName(callback.getActivity())) > 0) {
                    new UpdateDialog(callback.getActivity(), data).show();
                }
            }

            @Override
            public void onError(String errorCode, String errorMsg, String userMsg) {
                LogCore.i("UpdateController", "checkUpdate onError" + errorCode +  errorMsg);
            }
        });
    }



    private static String getAppName(Context context) {
        return context.getPackageName();
    }

    private static String getCurrentVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getAppName(context), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            LogCore.i(TAG, e);
        }
        return "1.0.0";
    }

    /**
     * 比较版本
     *
     * @param s1
     *            版本1
     * @param s2
     *            版本2
     * @return 如果版本1大于版本2，返回正数;如果版本1大于版本2，返回0;如果版本1小于版本2，返回负数
     */
    private static int compareVersion(String s1, String s2) {
        if (s1 == null && s2 == null){
            return 0;
        }
        else if (s1 == null){
            return -1;
        } else if (s2 == null){
            return 1;
        }
        String[] arr1 = s1.split("[^a-zA-Z0-9]+");
        String[] arr2 = s2.split("[^a-zA-Z0-9]+");
        int i1, i2, i3;
        for (int ii = 0, max = Math.min(arr1.length, arr2.length); ii <= max; ii++) {
            if (ii == arr1.length){
                return ii == arr2.length ? 0 : -1;
            }else if (ii == arr2.length){
                return 1;
            }
            try {
                i1 = Integer.parseInt(arr1[ii]);
            } catch (Exception x) {
                i1 = Integer.MAX_VALUE;
            }
            try {
                i2 = Integer.parseInt(arr2[ii]);
            } catch (Exception x) {
                i2 = Integer.MAX_VALUE;
            }

            if (i1 != i2) {
                return i1 - i2;
            }
        }
        return 0;
    }
}
