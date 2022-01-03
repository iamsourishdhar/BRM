package com.bank.account.manager.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ACOUNT_HOLDER_INVESTMENTS database table.
 * 
 */
@Entity
@Table(name="ACOUNT_HOLDER_INVESTMENTS")
@NamedQuery(name="AcountHolderInvestment.findAll", query="SELECT a FROM AcountHolderInvestment a")
public class AcountHolderInvestment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_HOLDER_INVESTMENT_ID_GENERATOR" ,sequenceName = "ACCOUNT_HOLDER_INVESTMENT_ID_GENERATOR",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_HOLDER_INVESTMENT_ID_GENERATOR")
	@Column(name="ACCOUNT_HOLDER_INVESTMENTS_ID")
	private long accountHolderInvestmentsId;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@Column(name="INVESTMENT_STATUS")
	private String investmentStatus;

	@Column(name="INVESTMENT_TYPE")
	private String investmentType;

	@Column(name="UPDATED_ON")
	private Timestamp updatedOn;

	//bi-directional many-to-one association to AccountHolder
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_HOLDER_ID")
	private AccountHolder accountHolder;

	public AcountHolderInvestment() {
	}

	public long getAccountHolderInvestmentsId() {
		return this.accountHolderInvestmentsId;
	}

	public void setAccountHolderInvestmentsId(long accountHolderInvestmentsId) {
		this.accountHolderInvestmentsId = accountHolderInvestmentsId;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getInvestmentStatus() {
		return this.investmentStatus;
	}

	public void setInvestmentStatus(String investmentStatus) {
		this.investmentStatus = investmentStatus;
	}

	public String getInvestmentType() {
		return this.investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public Timestamp getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public AccountHolder getAccountHolder() {
		return this.accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

}