package com.mao.pyhelper.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mao.baseapp.base.activity.LoadingActivity;
import com.mao.pyhelper.MainActivity;
import com.mao.pyhelper.R;

/**
 * 2018/6/28
 *
 * @author wangjf
 */

public class LoginActivity extends LoadingActivity implements View.OnClickListener{

    private Button mBtnLoginAdmin;
    private Button mBtnLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act_login);
        mBtnLoginAdmin = (Button)findViewById(R.id.btn_login_admin);
        mBtnLoginUser = (Button)findViewById(R.id.btn_login_user);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_admin:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.btn_login_user:
                break;
        }
    }
}
