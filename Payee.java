package com.banking.fundtransfer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Payee")
public class Payee 
{

	
@Id
@GeneratedValue
private int payeeId;


public Set<Account> getAccounts() 
{
	return accounts;
}

public void setAccounts(Set<Account> accounts) 
{
	this.accounts = accounts;
}


@Column(name="Beneficiary_Name",length=30)
String BenificiaryName;
@Column(name="Beneficairy_Account_Number")
long BeneficairyAccountNumber;
@Column(name="Beneficairy_Bank_Name", length=30)
String BeneficiaryBankName;
@Column(name="Beneficairy_Branch_Name",length=30)
String BeneficiaryBranchName;
@Column(name="Beneficairy_IFSC_CODE", length=11)
String BeneficairyIFSCCode;
@Column(name="Limit")
long BeneficairyLimit;
@Column(name="ContactNumber")
long ContactNumber;
@Column(name="email",length=20)
String Email;



@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
		name="account_payee_link_table",
		joinColumns = {@JoinColumn(name="payeeId")},
		inverseJoinColumns = {@JoinColumn(name="accountId")}
)
private Set<Account> accounts;


public String getBenificiaryName() 
{
	return BenificiaryName;
}

public void setBenificiaryName(String benificiaryName) 
{
	BenificiaryName = benificiaryName;
}

public long getBeneficairyAccountNumber() {
	return BeneficairyAccountNumber;
}

public void setBeneficairyAccountNumber(long beneficairyAccountNumber) {
	BeneficairyAccountNumber = beneficairyAccountNumber;
}

public String getBeneficiaryBankName() {
	return BeneficiaryBankName;
}

public void setBeneficiaryBankName(String beneficiaryBankName) {
	BeneficiaryBankName = beneficiaryBankName;
}

public String getBeneficiaryBranchName() {
	return BeneficiaryBranchName;
}

public void setBeneficiaryBranchName(String beneficiaryBranchName) {
	BeneficiaryBranchName = beneficiaryBranchName;
}

public String getBeneficairyIFSCCode() {
	return BeneficairyIFSCCode;
}

public void setBeneficairyIFSCCode(String beneficairyIFSCCode) {
	BeneficairyIFSCCode = beneficairyIFSCCode;
}

public long getBeneficairyLimit() {
	return BeneficairyLimit;
}

public void setBeneficairyLimit(long beneficairyLimit) {
	BeneficairyLimit = beneficairyLimit;
}



}
