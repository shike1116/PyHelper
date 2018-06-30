package com.mao.pyhelper.login;

import android.app.Activity;
import android.os.Bundle;

import com.mao.baseapp.login.controller.VerifyController;
import com.mao.pyhelper.MainActivity;
import com.mao.pyhelper.R;

public class VerifyActivity extends Activity{
    VerifyController mVerifyController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act_verify);
        mVerifyController = new VerifyController();
        mVerifyController.start(this, LoginActivity.class, MainActivity.class);

        //mVerifyController.start(this, MainActivity.class, LoginActivity.class);
    }
}
