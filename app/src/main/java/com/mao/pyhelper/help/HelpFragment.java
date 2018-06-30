package com.mao.pyhelper.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mao.baseapp.base.activity.LoadingFragment;
import com.mao.pyhelper.R;

/**
 * 2018/6/29
 *
 * @author wangjf
 */

public class HelpFragment extends LoadingFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fmg_help, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){

    }
}
