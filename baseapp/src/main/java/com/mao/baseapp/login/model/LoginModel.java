package com.mao.baseapp.login.model;

import android.text.TextUtils;

import com.mao.baseapp.common.log.LogCore;
import com.mao.baseapp.common.net.rest.BaseModel;
import com.mao.baseapp.common.net.rest.BizListener;
import com.mao.baseapp.common.utils.GsonUtils;
import com.mao.baseapp.common.utils.SPUtils;
import com.mao.baseapp.login.UserManage;
import com.mao.baseapp.login.entity.UserLoginPo;

import java.util.HashMap;
import java.util.Map;



public class LoginModel extends BaseModel {

    private static final String TAG = "LoginModel";


    public static void login(final String otherType,
                             final String otherId,
                             final String pwd,
                             final BizListener<UserLoginPo> listener){
        Map<String, String> params = new HashMap<String, String>();
        if(UserLoginPo.OTHER_TYPE_PHONE.equals(otherType)){
            params.put("otherId",otherId);
            params.put("password",pwd);
        }else{
            params.put("otherId",otherId);
        }

        params.put("otherType",otherType);
        params.put("userType", "1");
        getDetail("/m/mobile/us/user/usUserLogin/login", params,listener, UserLoginPo.class);
    }

    /**
     * 自动登录
     */
    public static void autoLogin(final BizListener<Object> listner) {
        final UserLoginPo userLoginPo = UserManage.getLoginUserPo();
        BizListener netListener = new BizListener<UserLoginPo>() {
            @Override
            public void onSuccess(UserLoginPo data) {
                UserManage.changeUserLoginPo(data);
                if(listner != null){
                    listner.onSuccess(null);
                }
            }

            @Override
            public void onError(String errorCode, String errorMsg, String userMsg) {
                if(listner != null){
                    listner.onError(errorCode, errorMsg, userMsg);
                }
            }
        };
        LoginModel.login(userLoginPo.otherType, userLoginPo.otherId, userLoginPo.password, netListener);
    }



    /************** 本地接口 *************/
    private static final String KEY_LOGIN_USER = "LOGIN_USER";
    public static void saveLoaclLoginUser(UserLoginPo userLoginPo){
        try{
            SPUtils.commitString(KEY_LOGIN_USER, GsonUtils.toJson(userLoginPo));
        }catch (Exception e){
            LogCore.i(TAG, e);
        }
    }

    public static UserLoginPo readLoaclLoginUser(){
        try{
            String jsonPo = SPUtils.getString(KEY_LOGIN_USER,"");
            if(!TextUtils.isEmpty(jsonPo)){
                return GsonUtils.fromJson(jsonPo, UserLoginPo.class);
            }
        }catch (Exception e){
            LogCore.i(TAG, e);
        }
        return null;
    }

    public static void clearUserLoginPo(){
        SPUtils.remove(KEY_LOGIN_USER);
    }
    /**
     * 检查 本地 是否登陆过
     */
    public static boolean checkHasLogined(){
        return UserManage.getLoginUserPo() != null;
    }
}
