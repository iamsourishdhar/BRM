package com.bank.account.manager.model;

public class AccountHolderDetails {
	
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String emailId;
	private InvestementDetails investementDetails;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public AccountHolderDetails(String firstName, String lastName, long mobileNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	public AccountHolderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvestementDetails getInvestementDetails() {
		return investementDetails;
	}
	public void setInvestementDetails(InvestementDetails investementDetails) {
		this.investementDetails = investementDetails;
	}
	

}
