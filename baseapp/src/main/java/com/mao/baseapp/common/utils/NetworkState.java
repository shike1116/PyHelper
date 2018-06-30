package com.mao.baseapp.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkState {
	// 网络状态码
	public static final int NETWORK_TYPE_WIFI = 1001; // wifi
	public static final int NETWORK_TYPE_GPRS = 1002; // 3G流量
	public static final int NETWORK_TYPE_NONE = 1003; // 无网
	private static ConnectivityManager cManager;
	private static NetworkState instance;

	private NetworkState(Context context) {
		init(context);
	}

	public static NetworkState getInstance(Context context) {
		if (instance == null) {
			instance = new NetworkState(context);
		}
		return instance;
	}

	public static void init(Context context) {
		if (cManager == null) {
			cManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		}
	}

	/**
	 * 判断网络状�?
	 * 
	 * @return 网络状态码
	 */
	public int getNetworkStateCode() {
		int networkState = -1; // 当前状态
		NetworkInfo nInfo = cManager.getActiveNetworkInfo();
		if (nInfo == null) {
			networkState = NETWORK_TYPE_NONE;
		} else {
			networkState = getNetworkConnectedSate(networkState);
		}
		return networkState;
	}

	/**
	 * 判断网络连接上的状�?
	 * 
	 * @return 网络状态码
	 */
	private int getNetworkConnectedSate(int networkState) {
		if (judgeNetworkInfo(ConnectivityManager.TYPE_MOBILE)) { // GPRS连接�?
			networkState = NETWORK_TYPE_GPRS;
		} else if (judgeNetworkInfo(ConnectivityManager.TYPE_WIFI)) { // WIFI连接�?
			networkState = NETWORK_TYPE_WIFI;
		} else {
			networkState = -1;
		}
		return networkState;
	}

	private boolean judgeNetworkInfo(int networkInfo) {
		NetworkInfo nInfo = cManager.getNetworkInfo(networkInfo);
		if (nInfo != null && nInfo.isConnected()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断网络是否连接
	 *
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		boolean nFlag = true;
		while (nFlag) {
			if (cManager != null) {
				nFlag = false;
				NetworkInfo nInfo = cManager.getActiveNetworkInfo();
				if (nInfo != null && nInfo.isConnected()) {
					if (nInfo.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
				break;
			} else {
				init(context);
			}
		}
		return false;
	}
}
