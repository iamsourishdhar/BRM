package com.bank.account.manager.model;

public class BaseResponse {
	private String statusCode;
	private String message;
	public String getStatusCode() {
		return statusCode;
	}
	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BaseResponse(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
}
