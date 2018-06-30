package com.mao.baseapp.common.net.request;

import java.util.Map;

public interface IHttpRequest {
	String TAG = "HttpRequest";
	public void doPostAsyn(final String urlStr, Map<String, String> mapParams,
						   final RequestListener listener);
	
	
}