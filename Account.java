package com.banking.fundtransfer.entity;



import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account 
{
	
	    @Id
	    @GeneratedValue
	    private Long accountId;
	    
        @Column(name="Account_Number")
	    long accountNumber;
        @Column(name="Account_Holder",length=30)
	    String accountHolder;
	    @Column(name="Balance")
	    double balance;
	    @Column(name="Contact_Number")
	    long contactNumber;
	    @Column(name="Email_Id",length=30)
	    String emailId;
	    @Column(name="Account_Type", length=20)
	    String accountType;

	    @OneToMany(mappedBy="Account",cascade =CascadeType.ALL,fetch=FetchType.EAGER)
	    List<Transaction> transactions;
	    
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(
				name="account_payee_link_table",
				joinColumns = {@JoinColumn(name="accountId")},
				inverseJoinColumns = {@JoinColumn(name="payeeId")}
		)
		private Set<Payee> payees;
	    
	    
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<Payee> getPayees() {
		return payees;
	}

	public void setPayees(Set<Payee> payees) {
		this.payees = payees;
	}
	   


}
