package com.mao.pyhelper.find;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mao.baseapp.base.activity.LoadingFragment;
import com.mao.pyhelper.R;


public class FindFragment extends LoadingFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fmg_find, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){

    }
}
