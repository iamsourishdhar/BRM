package com.bank.account.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.manager.dao.IF.AccountDaoIF;
import com.bank.account.manager.model.AccountHolderDetails;
import com.bank.account.manager.model.BaseResponse;
import com.bank.account.manager.service.IF.AccountServiceIF;
@Service
public class AccountServiceImpl implements AccountServiceIF {
	
	@Autowired
	 private AccountDaoIF accountDaoIF;

		@Override
		public BaseResponse persistAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
			return accountDaoIF.persistAccountHolderDetails(accountHolderDetails);
		}
		@Override
		public List<AccountHolderDetails> findAllAccountsHolder()
		{
			return accountDaoIF.findAllAccountsHolder();
		}
}
