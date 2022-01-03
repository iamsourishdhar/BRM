package com.bank.account.manager.model;

public class AccountDetails {
	private long accountNumber;
	private String accountType;
	private String accountShareType;
	private String accountCreatedOn;
	private double accountOpeningBalance;
	private double accountBalance;
	
	public AccountDetails() {
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountShareType() {
		return accountShareType;
	}
	public void setAccountShareType(String accountShareType) {
		this.accountShareType = accountShareType;
	}
	public String getAccountCreatedOn() {
		return accountCreatedOn;
	}
	public void setAccountCreatedOn(String accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}
	public double getAccountOpeningBalance() {
		return accountOpeningBalance;
	}
	public void setAccountOpeningBalance(double accountOpeningBalance) {
		this.accountOpeningBalance = accountOpeningBalance;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
