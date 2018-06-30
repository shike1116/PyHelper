package com.mao.baseapp.login.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


public class UsUserPo implements Parcelable {

	public static final String SEX_MAN = "0";
	public static final String SEX_WOMAN = "1";

	public int id;

	public String code;		// code bb号
	
	public String userType;		// user_type
	
	public String loginName;		// 登录名
	public String nickName;		// 昵称
	public String phone;		// 手机号码
	public String email;		// email
	public String wechat;		// 微信
	public String aliyaccout;	//支付宝
	public String sex;		// 性别

	public String signture;		// 个性签名
	public String photo;		// 头像URL
	public String status;		// 用户状态
	public String pushId;		// 消息推送ID
	public String imId;		// 即时消息用户ID

	public String isVip;		//是否VIP 0-否；1-是
	public Date vipDate;		//会员到期日

	public String token;

	public String question;//设置的问题
	public String background;//背景图片
	public double coin;

	public boolean isFriend;


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.code);
		dest.writeString(this.userType);
		dest.writeString(this.loginName);
		dest.writeString(this.nickName);
		dest.writeString(this.phone);
		dest.writeString(this.email);
		dest.writeString(this.wechat);
		dest.writeString(this.aliyaccout);
		dest.writeString(this.sex);
		dest.writeString(this.signture);
		dest.writeString(this.photo);
		dest.writeString(this.status);
		dest.writeString(this.pushId);
		dest.writeString(this.imId);
		dest.writeString(this.isVip);
		dest.writeLong(this.vipDate != null ? this.vipDate.getTime() : -1);
		dest.writeString(this.token);
		dest.writeString(this.question);
		dest.writeString(this.background);
		dest.writeDouble(this.coin);
	}

	public UsUserPo() {
	}

	protected UsUserPo(Parcel in) {
		this.id = in.readInt();
		this.code = in.readString();
		this.userType = in.readString();
		this.loginName = in.readString();
		this.nickName = in.readString();
		this.phone = in.readString();
		this.email = in.readString();
		this.wechat = in.readString();
		this.aliyaccout = in.readString();
		this.sex = in.readString();
		this.signture = in.readString();
		this.photo = in.readString();
		this.status = in.readString();
		this.pushId = in.readString();
		this.imId = in.readString();
		this.isVip = in.readString();
		long tmpVipDate = in.readLong();
		this.vipDate = tmpVipDate == -1 ? null : new Date(tmpVipDate);
		this.token = in.readString();
		this.question = in.readString();
		this.background = in.readString();
		this.coin = in.readDouble();
	}

	public static final Creator<UsUserPo> CREATOR = new Creator<UsUserPo>() {
		@Override
		public UsUserPo createFromParcel(Parcel source) {
			return new UsUserPo(source);
		}

		@Override
		public UsUserPo[] newArray(int size) {
			return new UsUserPo[size];
		}
	};
}