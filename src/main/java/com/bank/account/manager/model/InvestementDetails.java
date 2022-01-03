package com.bank.account.manager.model;

import java.util.ArrayList;
import java.util.List;

public class InvestementDetails {
	private List<AccountDetails> accountDetailsList=new ArrayList<>();

	public List<AccountDetails> getAccountDetailsList() {
		return accountDetailsList;
	}

	public void setAccountDetailsList(List<AccountDetails> accountDetailsList) {
		this.accountDetailsList = accountDetailsList;
	}

	public InvestementDetails() {
	
	}
	
	

}
