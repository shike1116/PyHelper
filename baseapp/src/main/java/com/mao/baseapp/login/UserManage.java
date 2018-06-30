package com.mao.baseapp.login;

import com.mao.baseapp.login.entity.UserLoginPo;
import com.mao.baseapp.login.model.LoginModel;

/**
 * Created by wangjf on 2016/10/19.
 */
public class UserManage {

    private static UserLoginPo mUserLoginPo;
    public static UserLoginPo getLoginUserPo(){
        if (mUserLoginPo == null){
            mUserLoginPo = LoginModel.readLoaclLoginUser();
        }
        return mUserLoginPo;
    }

    public static void changeUserLoginPo(UserLoginPo userLoginPo){
        mUserLoginPo = userLoginPo;
        LoginModel.saveLoaclLoginUser(userLoginPo);
    }


    /**
     * 获取 Token
     */
    public static String getToken(){
        if(getLoginUserPo().user != null){
            return getLoginUserPo().user.token;
        }
        return "";
    }
}
