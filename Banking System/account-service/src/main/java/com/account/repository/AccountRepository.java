package com.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	
	List<AccountEntity> findByCustomerId(Long customerId);
	AccountEntity findByCustomerIdAndAccountNumber(Long customerId,String accountNumber);
	AccountEntity findByAccountNumber(String accountNumber);
}
