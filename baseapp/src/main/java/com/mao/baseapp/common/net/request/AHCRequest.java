package com.mao.baseapp.common.net.request;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mao.baseapp.common.log.LogCore;

import java.util.Map;

import cz.msebera.android.httpclient.Header;


public class AHCRequest implements IHttpRequest{
    AsyncHttpClient client = new AsyncHttpClient();

	@Override
	public void doPostAsyn(final String urlStr, final  Map<String, String> mapParams,
			final RequestListener callBack)
	{
        RequestParams params = new RequestParams();
        for (Map.Entry<String, String> param : mapParams.entrySet()) {
            params.put(param.getKey(), param.getValue());
        }
        prinfParams(urlStr,mapParams);
        client.post(urlStr, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                LogCore.i(TAG,"请求成功： responseBody = "+ new String(responseBody));
                callBack.onRequestComplete(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if(responseBody!= null){
                    LogCore.i(TAG,"请求失败： statusCode ＝ " + statusCode +" responseBody "+ new String(responseBody) );
                }

                if(error!= null){
                    LogCore.i(TAG,"请求失败： statusCode ＝ " + statusCode +" error "+ error.getMessage());
                }


                callBack.onRequestError("405", "网络错误","请求发生错误");
            }
        });
	}

    protected void prinfParams(final String urlStr ,Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("&").append(entry.getKey()).append("=")
                    .append(entry.getValue());
        }
        LogCore.i(TAG,"请求开始："+ urlStr + sb.toString());

    }
}
