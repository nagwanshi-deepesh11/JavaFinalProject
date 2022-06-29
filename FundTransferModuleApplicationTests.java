package com.banking.fundtransfer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.banking.fundtransfer.entity.Account;
import com.banking.fundtransfer.entity.Login;
import com.banking.fundtransfer.entity.Payee;
import com.banking.fundtransfer.entity.Transaction;
import com.banking.fundtransfer.exceptions.PayeeListEmptyException;
import com.banking.fundtransfer.repository.AccountRepository;
import com.banking.fundtransfer.service.AccountService;
import com.banking.fundtransfer.service.LoginService;
import com.banking.fundtransfer.service.PayeeService;
import com.banking.fundtransfer.service.TransactionService;

@SpringBootTest
class FundTransferModuleApplicationTests

{

	@Autowired
	AccountService accServ;

	@Autowired
	TransactionService transactionService;

	@Autowired
	PayeeService payeeService;

	@Autowired
	LoginService loginService;

	@Autowired
	AccountRepository accountRepository;

	@Test
	void contextLoadsTest() {

		Account account1 = new Account();
		account1.setAccountNumber(530333271256L);
		account1.setAccountHolder("Ram Jain");
		account1.setBalance(500000);
		account1.setContactNumber(79741469l);
		account1.setEmailId("ram@sbi.co.in");
		account1.setAccountType("Savings Account");
//		System.out.println("Account1 Added.......");

		Payee payee2 = new Payee();
		payee2.setBenificiaryName("Jayant Sachdeva");
		payee2.setBeneficairyAccountNumber(53033370l);
		payee2.setBeneficairyIFSCCode("BARBOMAHIDP");
		payee2.setBeneficairyLimit(300000);
		payee2.setBeneficiaryBankName("BANK OF BARODA");
		payee2.setBeneficiaryBranchName("Mahidpur");
		payee2.setContactNumber(02362131);
		payee2.setEmail("test");
		// payeeService.addPayeeService(payee2);
//		
//		
//		

//	//	payeeService.addPayeeService(payee5);

		Set<Payee> newSet = new HashSet<Payee>();
		newSet.add(payee2);

		account1.setPayees(newSet);

		List<Transaction> txnSet = new ArrayList<Transaction>();
		Transaction txn = new Transaction();
//	    txn.setAccountId(account1);
		txn.setCreditAmount(30000);
		txn.setDebitAmount(0);
		txn.setReferenceNumber("SBIN003072261");
		String str = "2022-05-10";
		Date date = Date.valueOf(str);
		txn.setTransactionDate(date);
		txn.setUpdatedBalance(35000);
		txnSet.add(txn);
		account1.setTransactions(txnSet);
		Assertions.assertTrue(account1 != null);
		System.out.println("Ran till assert");

		accServ.saveAccountService(account1);

	}

	@Test
	void contextPayeeTest() {

	}

	@Test
	void findAllPayee() throws PayeeListEmptyException {
//		List<Payee> payeeList = new ArrayList<Payee>();
//		
//		payeeList  = (List<Payee>) payeeService.findAllPayeeService();
//		for (Payee payee : payeeList) 
//		{
//			System.out.println("Beneficaiary_Name  : "+payee.getBenificiaryName());
//			System.out.println("Beneficaiary Account_Number   : "+payee.getBeneficairyAccountNumber());
//			System.out.println("Beneficairy_Bank_Name: "+payee.getBeneficiaryBankName());
//			System.out.println("Beneficairy_Branch_Name  : "+payee.getBeneficiaryBranchName());
//			System.out.println("IFSC CODE : "+payee.getBeneficairyIFSCCode());
//			System.out.println("Limit: "+payee.getBeneficairyLimit());
//			System.out.println("------------------------");
//		}

	}

	@Test
	void loginTest() {

		Login login = new Login();
		login.setUsername("Ram_jain");
		login.setPassword("ramjain");
		login.setAccountId(321);
		loginService.saveLoginService(login);

		// Set<Account> newSet = new HashSet<Account>() ;

	}
@Test
	void findAccount()

	{
		Account account=accountRepository.findByAccountNumber(9876543);
		System.err.println(""+account);
	}
}
