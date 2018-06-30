package com.mao.baseapp.common.net.dto;

public class RestStatus {
	private Boolean status;
	private String errorCode;
	private String userMessage;
	private String errorMessage;

	public RestStatus() {
		this.errorCode = "";
		this.errorMessage = "";
	}

	public RestStatus(Boolean status) {
		this.status = status;
		this.errorCode = "";
		this.errorMessage = "";
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
