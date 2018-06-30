package com.mao.baseapp.login;

import com.mao.baseapp.common.net.rest.BaseModel;
import com.mao.baseapp.common.net.rest.BizListener;
import com.mao.baseapp.login.entity.UserLoginPo;

import java.util.HashMap;
import java.util.Map;

/**
 * 2018/6/28
 *
 * @author wangjf
 */

public class LoginAPI extends BaseModel {

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
        getDetail("/m/mobile/us/user/usUserLogin/login", params, listener, UserLoginPo.class);
    }
}
