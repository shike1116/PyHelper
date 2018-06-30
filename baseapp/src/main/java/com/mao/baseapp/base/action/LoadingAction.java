package com.mao.baseapp.base.action;


import android.app.Activity;
import android.view.Gravity;
import android.widget.Toast;

import com.mao.baseapp.common.ui.dialog.LoadingDialog;
import com.mao.baseapp.common.ui.toast.ContentAssistToast;
import com.mao.baseapp.common.utils.SoftWareUtils;

public class LoadingAction{
    private Callback mCallbak;
    private LoadingDialog mLoadingDialog;
    public LoadingAction(Callback callbak){
        this.mCallbak = callbak;
    }
    public void showToast(int res) {
        String content = mCallbak.getStringById(res);
        if(content != null){
            showToast(content);
        }
    }

    public void showActionLoading(final int res) {
        String content = mCallbak.getStringById(res);
        if(content != null){
            showActionLoading(content);
        }
    }

    public void setErrorInfo(final int res) {
        String content = mCallbak.getStringById(res);
        if(content != null){
            setErrorInfo(content);
        }
    }

    public void showToast(final String content) {
        run(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mCallbak.getActivity(), content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showActionLoading(final String text) {
        run(new Runnable() {
            @Override
            public void run() {
                mLoadingDialog = LoadingDialog.show(mCallbak.getActivity(), text);
            }
        });
    }

    public void setErrorInfo(final String error) {
        run(new Runnable() {
            @Override
            public void run() {
                SoftWareUtils.hideSoftWare(mCallbak.getActivity());
                ContentAssistToast toast = ContentAssistToast.makeText(mCallbak.getActivity(), error);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Toast.makeText(mCallbak.getActivity(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void dismissLoadingDialog() {
        if (!mCallbak.isDestroy() && mLoadingDialog != null
                && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    private void run(Runnable action){
        if(mCallbak.isDestroy()){
            return;
        }
        mCallbak.runOnUiThread(action);
    }


    public interface Callback{
        boolean isDestroy();
        String getStringById(int res);
        void runOnUiThread(Runnable action);
        Activity getActivity();
    }


}
