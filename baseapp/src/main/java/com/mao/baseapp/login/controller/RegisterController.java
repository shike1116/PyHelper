package com.mao.baseapp.login.controller;

import android.text.TextUtils;
import android.widget.EditText;

import com.mao.baseapp.base.action.LoadingAction;
import com.mao.baseapp.base.controller.LoadingController;
import com.mao.baseapp.login.model.FormModel;


/**
 * Created by wangjf on 2016/10/15.
 */
public class RegisterController extends LoadingController {

    public RegisterController(LoadingAction.Callback callback) {
        super(callback);
    }

    public void regiter(EditText etPhone,EditText etPsw,EditText etPswConfirm){

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

        if(etPswConfirm != null){
            final String pwdConfirm = etPswConfirm.getText().toString().trim();
            if(pwd.equals(pwdConfirm)){
                showErrorInfo("两次输入密码不一致");
                return;
            }
        }
        getCode(phone);
    }


    public void getCode(String phone){

    }

    //public void


}
