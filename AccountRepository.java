package com.banking.fundtransfer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.fundtransfer.entity.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>,JpaRepository<Account, Integer>
{

	Account findByAccountNumber(long accountNumber);
}
