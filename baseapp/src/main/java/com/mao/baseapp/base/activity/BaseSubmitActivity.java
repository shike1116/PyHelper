package com.mao.baseapp.base.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mao.baseapp.base.action.LoadingAction;
import com.mao.baseapp.base.action.SubmitImageAction;
import com.mao.baseapp.common.utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseSubmitActivity extends LoadingActivity implements SubmitImageAction.Callback{


    private SubmitImageAction mSubmitImageAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSubmitImageAction = new SubmitImageAction(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mSubmitImageAction.onActivityResult(requestCode,resultCode, data,this);
    }


    public void getNormalPhoto(int maxCount, ArrayList<String> selectedUrl){
        mSubmitImageAction.getNormalPhoto(maxCount,selectedUrl, this);
    }

    @Override
    public void handlerGetImage(List<String> resultList) {
        showToast("handlerShowImage " + GsonUtils.toJson(resultList));
    }

    @Override
    public void handlerShowImage(List<String> resultList) {

        showToast("handlerShowImage " +GsonUtils.toJson(resultList));
    }

    @Override
    public void hadnlerClipImage(String resultUrl) {

        showToast("hadnlerClipImage " + resultUrl);
    }
}
