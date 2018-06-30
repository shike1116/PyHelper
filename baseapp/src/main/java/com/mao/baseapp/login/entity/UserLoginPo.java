/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mao.baseapp.login.entity;

/**
 * 用户登录Entity
 * @author xieqc
 * @version 2016-03-04
 */
public class UserLoginPo {

	public static final String OTHER_TYPE_PHONE = "0";
	public static final String OTHER_TYPE_WX = "1";

	public Integer userId;			//用户ID
	public Integer userType;		// 用户类型
	public String otherType;		// other_type
	public String otherId;		// other_id
	public String password;		// 密码
	public String pushId;			//推送ID 登录的时候传值
	public UsUserPo user;			//用户
	
}