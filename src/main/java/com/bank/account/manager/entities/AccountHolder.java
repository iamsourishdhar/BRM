package com.bank.account.manager.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the ACCOUNT_HOLDER database table.
 * 
 */
@Entity
@Table(name="ACCOUNT_HOLDER")
@NamedQuery(name="AccountHolder.findAll", query="SELECT a FROM AccountHolder a")
public class AccountHolder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_HOLDER_ACCOUNTHOLDERID_GENERATOR" ,sequenceName = "ACCOUNT_HOLDER_ACCOUNTHOLDERID_GENERATOR",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_HOLDER_ACCOUNTHOLDERID_GENERATOR")
	@Column(name="ACCOUNT_HOLDER_ID")
	private long accountHolderId;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PHONE_NUMBER")
	private BigDecimal phoneNumber;

	//bi-directional many-to-one association to AcountHolderInvestment
	@OneToMany(mappedBy="accountHolder",cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.LAZY)
	private List<AcountHolderInvestment> acountHolderInvestments;

	public AccountHolder() {
	}

	public long getAccountHolderId() {
		return this.accountHolderId;
	}

	public void setAccountHolderId(long accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(BigDecimal phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<AcountHolderInvestment> getAcountHolderInvestments() {
		return this.acountHolderInvestments;
	}

	public void setAcountHolderInvestments(List<AcountHolderInvestment> acountHolderInvestments) {
		this.acountHolderInvestments = acountHolderInvestments;
	}

	public AcountHolderInvestment addAcountHolderInvestment(AcountHolderInvestment acountHolderInvestment) {
		getAcountHolderInvestments().add(acountHolderInvestment);
		acountHolderInvestment.setAccountHolder(this);

		return acountHolderInvestment;
	}

	public AcountHolderInvestment removeAcountHolderInvestment(AcountHolderInvestment acountHolderInvestment) {
		getAcountHolderInvestments().remove(acountHolderInvestment);
		acountHolderInvestment.setAccountHolder(null);

		return acountHolderInvestment;
	}

}