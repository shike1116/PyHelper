package com.mao.baseapp.common.net.rest;

import java.util.List;

public interface BizListener<T> {
	
	public void onSuccess(T data);

	public void onError(String errorCode, String errorMsg, String userMsg);
}
