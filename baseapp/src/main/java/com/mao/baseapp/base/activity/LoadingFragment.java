package com.mao.baseapp.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.mao.baseapp.base.action.LoadingAction;


public class LoadingFragment extends Fragment implements LoadingAction.Callback{

    private LoadingAction mLoadingAction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingAction = new LoadingAction(this);
    }

    @Override
    public boolean isDestroy() {
        Activity activity = getActivity();
        return activity == null || activity.isFinishing();
    }

    public void bindListener(View.OnClickListener onClickListener,int... viewIds) {
        Activity activity = getActivity();
        if(activity == null || activity.isFinishing()){
            return;
        }
        for (int viewId : viewIds) {
            View view = activity.findViewById(viewId);
            if(view != null){
                view.setOnClickListener(onClickListener);
            }
        }
    }

    @Override
    public String getStringById(int res) {
        if(isDestroy()){
            return null;
        }else {
            return getActivity().getString(res);
        }
    }

    @Override
    public void runOnUiThread(Runnable action) {
        if(!isDestroy()){
            getActivity().runOnUiThread(action);
        }
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
