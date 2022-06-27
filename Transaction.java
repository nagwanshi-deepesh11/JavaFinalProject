package com.banking.fundtransfer.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction
{
@Id
@GeneratedValue
private int transactionId;

String ReferenceNumber;

Date transactionDate;

private double DebitAmount;

private double CreditAmount;

private double updatedBalance;




//@ManyToOne(mappedBy="",cascade =CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="Account_Number")
Account account;




public String getReferenceNumber() {
	return ReferenceNumber;
}




public void setReferenceNumber(String referenceNumber) {
	ReferenceNumber = referenceNumber;
}




public Date getTransactionDate() {
	return transactionDate;
}




public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}




public double getDebitAmount() {
	return DebitAmount;
}




public void setDebitAmount(double debitAmount) {
	DebitAmount = debitAmount;
}




public double getCreditAmount() {
	return CreditAmount;
}




public void setCreditAmount(double creditAmount) {
	CreditAmount = creditAmount;
}




public double getUpdatedBalance() {
	return updatedBalance;
}




public void setUpdatedBalance(double updatedBalance) {
	this.updatedBalance = updatedBalance;
}




public Account getAccount() {
	return account;
}




public void setAccount(Account account) {
	this.account = account;
}



}
