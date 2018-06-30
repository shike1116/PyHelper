package com.mao.baseapp.login.controller;

import android.text.TextUtils;
import android.widget.EditText;

import com.mao.baseapp.base.action.LoadingAction;
import com.mao.baseapp.base.controller.LoadingController;
import com.mao.baseapp.common.net.rest.BizListener;
import com.mao.baseapp.login.entity.UserLoginPo;
import com.mao.baseapp.login.model.FormModel;
import com.mao.baseapp.login.model.LoginModel;


public class LoginController extends LoadingController {

    public LoginController(LoadingAction.Callback callback) {
        super(callback);
    }

    public void login(EditText etPhone,EditText etPsw){

        final String phone = etPhone.getText().toString().trim();
        final String pwd = etPsw.getText().toString().trim();

        if(TextUtils.isEmpty(phone)){
            showErrorInfo("请填写手机号码");
            return;
        }else if(TextUtils.isEmpty(pwd)){
            showErrorInfo("请填写密码");
            return;
        }else if(!FormModel.checkPhone(phone)) {
            showErrorInfo("手机号码格式不对");
            return;
        }else if(!FormModel.checkPwd(pwd)){
            showErrorInfo("密码格式不对");
            return;
        }
        login(UserLoginPo.OTHER_TYPE_PHONE, phone, pwd);
    }

    private void loginWeixing(){

    }

    public void login(final String otherType,
                      final String otherId,
                      final String pwd){
        showActionLoading("正在登陆");
        LoginModel.login(otherType, otherId, pwd, new BizListener<UserLoginPo>() {
            @Override
            public void onSuccess(UserLoginPo data) {
//                dismissLoadingDialog();
//                if (isUserInfoMiss(data)) {
//                    TempDataMessage.getInstance().setUserLoginPo(data, pwd);
//                    LoginIntentManager.intent2SettingInfo(LoginActivity.this);
//                } else {
//                    data.password = pwd;
//                    MyApplication.getInstance().setUserLoginPo(data);
//                    MainIntentManager.intent2Mian(LoginActivity.this);
//                }
            }

            @Override
            public void onError(String errorCode, String errorMsg, String userMsg) {
                dismissLoadingDialog();
                showErrorInfo(userMsg);
            }
        });
    }

    private boolean checkUserInfoComplete(UserLoginPo userLoginPo){
        return true;
    }

}
