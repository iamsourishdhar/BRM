package com.bank.account.manager.dao.IF;

import java.util.List;

import com.bank.account.manager.model.AccountHolderDetails;
import com.bank.account.manager.model.BaseResponse;

public interface AccountDaoIF {

	
	BaseResponse persistAccountHolderDetails(AccountHolderDetails accountHolderDetails);
	
	 List<AccountHolderDetails> findAllAccountsHolder();
}
