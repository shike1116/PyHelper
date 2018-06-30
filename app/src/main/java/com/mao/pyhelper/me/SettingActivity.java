package com.mao.pyhelper.me;

import android.os.Bundle;

import com.mao.baseapp.base.activity.LoadingActivity;
import com.mao.pyhelper.R;

/**
 * Created by wjf on 18/6/30.
 */

public class SettingActivity extends LoadingActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_act_setting);
        bindTitleBar(R.id.title);
    }
}
