package com.bank.account.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.account.manager.entities.AccountHolder;

@Transactional(value = "PrimaryDBTransactionManager")
//@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long>{
	
	public AccountHolder findByEmailId(String emailId);
	

}
