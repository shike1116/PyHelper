package com.mao.baseapp.common.net;

import com.mao.baseapp.common.net.request.AHCRequest;
import com.mao.baseapp.common.net.request.IHttpRequest;
import com.mao.baseapp.common.net.request.RequestListener;

import java.util.HashMap;
import java.util.Map;

public class RequestManager {
	private static final String TAG = "RequestManager";

	//public static final String ROOT_URL = "http://bbb.aiwansport.com";
	public static final String ROOT_URL = "http://app.bbfrds.com";
	private static final String APP_SECRET = "Heju123456";
	private Map<String, String> mDeviceParams = new HashMap<String, String>();

	private static class LazyHolder {
		private static final RequestManager INSTANCE = new RequestManager();
	}

	private IHttpRequest mHttpRequest = new AHCRequest();

	private RequestManager() {
	}

	public static final RequestManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void postMyServer(final String urlStr, Map<String, String> mapParams, final RequestListener callBack) {

//		addDeviceInfo(mapParams);
//		addSign(mapParams);
//		if(urlStr.startsWith("/m/mobile/") ){
//			post(getServicePath(urlStr), mapParams, callBack);
//		}else{
//			if(!mapParams.containsKey("token")) {
//				mapParams.put("token", MyApplication.getInstance().getUserToken());
//			}
//			postWithToken(getServicePath(urlStr), mapParams, callBack);
//		}
	}
	public void postWithToken(final String urlStr, final Map<String, String> mapParams, final RequestListener modelListener){
//		RequestListener tokenlistener = new RequestListener() {
//			@Override
//			public void onRequestComplete(String result) {
//				RestStatus restStatus = NetGsonUtil.fromJson(result,RestStatus.class);
//				if(restStatus == null || restStatus.getStatus()|| !restStatus.getErrorCode().equals("545")){
//					modelListener.onRequestComplete(result);
//				}else{
//					Log.i(TAG,"token失效 重新获取");
//					LoginModel.autoLogin(new BizListener<Object>() {
//						@Override
//						public void onSuccess(Object data) {
//							mapParams.put("token", MyApplication.getInstance().getUserToken());
//							post(urlStr, mapParams, modelListener);
//						}
//
//						@Override
//						public void onError(String errorCode, String errorMsg, String userMsg) {
//							modelListener.onRequestError(errorCode, errorMsg, userMsg);
//						}
//					});
//				}
//			}
//
//			@Override
//			public void onRequestError(String errorCode, String errorMsg, String userMsg) {
//				modelListener.onRequestError(errorCode,errorMsg,userMsg);
//			}
//		};
//		post(urlStr, mapParams, tokenlistener);
	}




	public void post(final String fullUrl, Map<String, String> mapParams,
			final RequestListener callBack) {
		mHttpRequest.doPostAsyn(fullUrl, mapParams, callBack);
	}

	private String getServicePath(String urlStr) {
		StringBuffer sb = new StringBuffer();
		sb.append(ROOT_URL).append(urlStr);
		return sb.toString();
	}

	private  void addDeviceInfo(Map<String, String> mapParams){
		if (mDeviceParams.size()== 0){
//			Context context = AppContext.getInstance();
//			mDeviceParams.put("channelId", AppTools.getChannelId(context));
//			mDeviceParams.put("imei", AppTools.getImei(context));
//			mDeviceParams.put("imsi", AppTools.getImsi(context));
//			mDeviceParams.put("mac", AppTools.getMac(context));
//			mDeviceParams.put("versionName", AppTools.getCurrentVersionName(context));
//			mDeviceParams.put("versionCode", AppTools.getCurrentVersionCode(context));
//			mDeviceParams.put("device", AppTools.getDevice(context));
			//mDeviceParams.put("ratio", AppUtils.getRatio(context));
			mDeviceParams.put("deviceType", "android");
		}
		mapParams.putAll(mDeviceParams);
	}
	private void addSign(Map<String, String> mapParams){
//		int num = (int)(Math.random()*5);
//		StringBuilder basestring = new StringBuilder();
//		Object[] key = mapParams.keySet().toArray();
//		Arrays.sort(key);
//		for (int i = 0; i < key.length; i++) {
//			basestring.append(key[i]).append("=").append(mapParams.get(key[i]));
//		}
//
//		String sign = basestring.append(APP_SECRET).toString();
//		for(int i=0;i<=num;i++){
//			sign = MD5.GetMD5Code(sign)+num;
//		}
//		mapParams.put("num", num);
//		mapParams.put("sign", sign);
	}

	
}
