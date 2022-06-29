package com.banking.fundtransfer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.fundtransfer.entity.Account;

import com.banking.fundtransfer.repository.AccountRepository;
import com.banking.fundtransfer.service.AccountService;






@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController 
{
	
@Autowired 
AccountService accountService;

@Autowired AccountRepository accountRepository;

	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account)
	{
	ResponseEntity<Account> responseRef = null;
	Account modifiedAccount = accountService.saveAccountService(account);
	
	responseRef = ResponseEntity.ok(modifiedAccount);
	return responseRef;
	}
	
	 @GetMapping("/getAccount/{id}")
	 public ResponseEntity<Account> getAccount(@PathVariable("id") int accId){
	 	Account acc = null;
			ResponseEntity responseRef=null;
			try {
				acc = accountService.getAccountService(accId);
				responseRef = ResponseEntity.ok(acc);
				return responseRef;
			} catch (Exception e) 
			{
				throw e;
				}
	
	 }
	 
	 @GetMapping("/getPayeeByAccountNumber/{accountNumber}")
	 public ResponseEntity<Account> getPayeeByAccountNumber(@PathVariable("accountNumber") long accountNumber)
	{
		//Payee payee=null;
		
			ResponseEntity responseRef=null;
		Account account1=accountRepository.findByAccountNumber(accountNumber);
		responseRef = ResponseEntity.ok(account1);
		return responseRef;

}
}
