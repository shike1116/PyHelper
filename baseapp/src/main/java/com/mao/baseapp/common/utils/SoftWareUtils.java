package com.mao.baseapp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SoftWareUtils {

    public static final String TAG ="SoftWareUtils";

    public static void hideSoftWare(Activity context) {
        if (context != null && context.getCurrentFocus() != null && context.getCurrentFocus().getWindowToken() != null) {
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    context.getCurrentFocus().getWindowToken(),
                    0);
        }
    }

    public static void showSoftWare(Activity cActivity, View view) {
        if(cActivity == null || view == null) return;
        InputMethodManager manager = (InputMethodManager) cActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void toggleSoftWare(Activity cActivity) {
        if(cActivity == null) return;
        InputMethodManager manager = (InputMethodManager) cActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showSoftWare(Context context, View view) {
        if(context == null || view == null) return;
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

}
