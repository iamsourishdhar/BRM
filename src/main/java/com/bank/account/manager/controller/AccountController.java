package com.bank.account.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.manager.model.AccountHolderDetails;
import com.bank.account.manager.model.BaseResponse;
import com.bank.account.manager.service.IF.AccountServiceIF;

@RestController
public class AccountController {
	@Autowired
	private AccountServiceIF accountServiceIF;
	
	@PostMapping("/createaccountholder")
	public BaseResponse persistAccountHolderDetails(@RequestBody AccountHolderDetails accountHolderDetails)
	{
		BaseResponse baseResponse=accountServiceIF.persistAccountHolderDetails(accountHolderDetails);
		
		return baseResponse;
	}
	
	@GetMapping("/allaccountholders")
	public  List<AccountHolderDetails> getAllAccountHolderDetails()
	{
		return accountServiceIF.findAllAccountsHolder();
	}

}
