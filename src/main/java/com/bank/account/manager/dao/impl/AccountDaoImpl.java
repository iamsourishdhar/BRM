package com.bank.account.manager.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bank.account.manager.dao.IF.AccountDaoIF;
import com.bank.account.manager.entities.AccountHolder;
import com.bank.account.manager.entities.AcountHolderInvestment;
import com.bank.account.manager.model.AccountDetails;
import com.bank.account.manager.model.AccountHolderDetails;
import com.bank.account.manager.model.BaseResponse;
import com.bank.account.manager.repo.AccountHolderRepository;
@Service
public class AccountDaoImpl implements AccountDaoIF {
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	@Override
	public BaseResponse persistAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
		try {
			AccountHolder accountHolder = new AccountHolder();
			accountHolder.setFirstName(accountHolderDetails.getFirstName());
			accountHolder.setLastName(accountHolderDetails.getLastName());
			accountHolder.setEmailId(accountHolder.getEmailId());
			accountHolder.setPhoneNumber(BigDecimal.valueOf(accountHolderDetails.getMobileNumber()));
			if (null != accountHolderDetails.getInvestementDetails()) {
				List<AcountHolderInvestment> acountHolderInvestmentList = new ArrayList<>();
				if (!CollectionUtils.isEmpty(accountHolderDetails.getInvestementDetails().getAccountDetailsList())) {
					for (AccountDetails accountDetails : accountHolderDetails.getInvestementDetails()
							.getAccountDetailsList()) {
						AcountHolderInvestment acountHolderInvestment = new AcountHolderInvestment();
						acountHolderInvestment.setInvestmentType(accountDetails.getAccountType());
						/*
						 * acountHolderInvestment .setCreatedOn(new
						 * Timestamp(Long.valueOf(accountDetails.getAccountCreatedOn())));
						 */						acountHolderInvestment.setAccountHolder(accountHolder);
						acountHolderInvestmentList.add(acountHolderInvestment);
					}

				}
				accountHolder.setAcountHolderInvestments(acountHolderInvestmentList);
			}
			accountHolderRepository.save(accountHolder);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}
	@Cacheable(cacheNames = { "userCache" })
	@Override
	public List<AccountHolderDetails> findAllAccountsHolder() {
		List<AccountHolderDetails> accountHolderDetailsLst = new ArrayList<>();
		List<AccountHolder> accountHolderList = accountHolderRepository.findAll();
		if (!CollectionUtils.isEmpty(accountHolderList)) {
			accountHolderList.stream().forEach(obj -> {
				AccountHolderDetails accountHolderDetails = new AccountHolderDetails();
				accountHolderDetails.setEmailId(obj.getEmailId());
				accountHolderDetails.setFirstName(obj.getFirstName());
				accountHolderDetails.setLastName(obj.getLastName());
				accountHolderDetailsLst.add(accountHolderDetails);

			});
		}

		return accountHolderDetailsLst;

	}

}
