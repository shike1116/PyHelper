package com.mao.baseapp.common.net.rest;

import com.mao.baseapp.common.net.RequestManager;
import com.mao.baseapp.common.net.dto.DetailDTO;
import com.mao.baseapp.common.net.dto.ListDTO;
import com.mao.baseapp.common.net.request.RequestListener;
import com.mao.baseapp.common.net.util.NetGsonUtil;

import java.util.List;
import java.util.Map;

public class BaseModel {

	protected static void onHttpPost(String url, Map<String, String> mapParams,
			RequestListener mRListener) {
		RequestManager.getInstance().postMyServer(url, mapParams, mRListener);
	}

	protected static  <T> void getList(String url, Map<String, String> mapParams,
			final BizListener<List<T>> listener, final Class clazz) {
		RequestListener requestListener = new RequestListener() {

			public void onRequestError(String errorCode, String errorMsg, String usermsg) {
				if (listener != null) {
					listener.onError(errorCode, errorMsg, usermsg);
				}
			}

			public void onRequestComplete(String result) {

				ListDTO<T> update = fromListJson(result, clazz);
				if (listener != null) {
					if(update == null){
						listener.onError("", "", "请求失败了");
					}else if(update.getStatus()){
						listener.onSuccess(update.getList());
					}else {
						listener.onError(update.getErrorCode(), update.getErrorMessage(), update.getUserMessage());
					}
				}
			}
		};
		onHttpPost(url, mapParams, requestListener);
	}

	protected static <T> void getDetail(String url, Map<String, String> mapParams,
			final BizListener<T> listener, final Class clazz) {
		RequestListener requestListener = new RequestListener() {

			public void onRequestError(String errorCode, String errorMsg, String userMsg) {
				if (listener != null) {
					listener.onError(errorCode, errorMsg, userMsg);
				}
			}

			public void onRequestComplete(String result) {
				DetailDTO<T> update = fromDetailJson(result, clazz);
				if(update == null){
					listener.onError("", "", "请求失败了");
				}else if(update.getStatus()){
					listener.onSuccess(update.getDetail());
				}else {
					listener.onError(update.getErrorCode(), update.getErrorMessage(), update.getUserMessage());
				}
			}
		};
		onHttpPost(url, mapParams, requestListener);
	}

	protected static DetailDTO fromDetailJson(String json, Class clazz) {
		DetailDTO dto = NetGsonUtil.fromDetailJson(json, clazz);
		if(dto == null){
			dto =  NetGsonUtil.fromDetailJson2(json, clazz);
		}
		return dto;
	}

	protected static ListDTO fromListJson(String json, Class clazz) {
		ListDTO dto =  NetGsonUtil.fromListJson(json, clazz);
		if(dto == null){
			dto =  NetGsonUtil.fromListJson2(json, clazz);
		}
		return dto;
	}

}
