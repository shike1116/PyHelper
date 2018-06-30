package com.mao.baseapp.base.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.mao.baseapp.base.action.LoadingAction;


public class LoadingFmgActivity extends FragmentActivity implements LoadingAction.Callback{
    private boolean isDestroy;
    private LoadingAction mLoadingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingAction = new LoadingAction(this);
        isDestroy = false;
    }

    public void bindListener(View.OnClickListener onClickListener,int... viewIds) {
        for (int viewId : viewIds) {
            View view = findViewById(viewId);
            if(view != null){
                view.setOnClickListener(onClickListener);
            }
        }
    }

    @Override
    public boolean isDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return isDestroyed();
        } else {
            return isDestroy;
        }
    }

    @Override
    public String getStringById(int res) {
        return getString(res);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        dismissLoadingDialog();
        super.onDestroy();
        isDestroy = true;
    }

    public void showActionLoading(final int res) {
        if(mLoadingAction != null){
            mLoadingAction.showActionLoading(res);
        }
    }

    public void showActionLoading(final String text) {
        if(mLoadingAction != null){
            mLoadingAction.showActionLoading(text);
        }
    }

    public void dismissLoadingDialog() {
        if(mLoadingAction != null){
            mLoadingAction.dismissLoadingDialog();
        }
    }

    public void showToast(final String content) {
        if(mLoadingAction != null){
            mLoadingAction.showToast(content);
        }
    }

    public void showToast(int res) {
        if(mLoadingAction != null){
            mLoadingAction.showToast(res);
        }
    }

    public void showErrorInfo(final String content) {
        if(mLoadingAction != null){
            mLoadingAction.setErrorInfo(content);
        }
    }

    public void showErrorInfo(final int res) {
        if(mLoadingAction != null){
            mLoadingAction.setErrorInfo(res);
        }
    }

}
