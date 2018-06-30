package com.mao.baseapp.common.net.request;

public interface RequestListener {
	
	void onRequestComplete(String result);
	
	void onRequestError(String errorCode, String errorMsg, String userMsg);
	
}
