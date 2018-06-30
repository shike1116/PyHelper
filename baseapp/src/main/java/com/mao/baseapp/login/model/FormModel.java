package com.mao.baseapp.login.model;

/**
 * Created by wangjf on 2016/10/15.
 */
public class FormModel {

    public static boolean checkPhone(String phone){
        return phone.length() == 11;
    }

    public static boolean checkPwd(String pwd){
        return pwd.length() >= 6;
    }
}
