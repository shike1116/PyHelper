package com.mao.baseapp.update.entity;

public class UpdatePo {

	public Integer id;
	public String channelCode;		// 渠道号
	public String platform;		// 平台 1-Android;2-IOS
	public String versions;		// 版本号
	public String patchUrl;		// 增量包
	public String url;		// 下载路径
	public String isForce;		// 是否强制更新 0-否；1-是
	public String isIgnore;		// 是否忽略 0-否；1-是
	public String defaults;		// defaults
	public String desrc;		// 描述

	
}