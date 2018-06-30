package com.mao.baseapp.common.net.rest;

public abstract class SuccessListener<T> implements BizListener<T> {

	public void onError(String errorCode, String errorMsg, String userMsg) {
	}
}
