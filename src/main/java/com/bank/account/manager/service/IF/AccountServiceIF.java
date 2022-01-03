package com.bank.account.manager.service.IF;

import java.util.List;

import com.bank.account.manager.model.AccountHolderDetails;
import com.bank.account.manager.model.BaseResponse;

public interface AccountServiceIF {
	 BaseResponse persistAccountHolderDetails(AccountHolderDetails accountHolderDetails);
	 
	 List<AccountHolderDetails> findAllAccountsHolder();
}
