package com.mao.baseapp.base.controller;


import com.mao.baseapp.base.action.LoadingAction;

/**
 *
 * Created by wjf on 16/10/9.
 */
public class LoadingController{

    private LoadingAction mLoadingAction;

    public LoadingController(LoadingAction.Callback callback){
        mLoadingAction = new LoadingAction(callback);
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
