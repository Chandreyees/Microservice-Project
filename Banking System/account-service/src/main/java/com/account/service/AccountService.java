package com.account.service;

import java.util.List;

import com.account.dao.AccountModel;
import com.account.dao.TransactionRequest;
import com.account.dao.ApiResponseModel;

public interface AccountService {

	AccountModel getAccountDetails(Long id);

	ApiResponseModel addMoneyToAccount(TransactionRequest model);

	AccountModel withdrawMoneyFromAccount(TransactionRequest model);

	List<AccountModel> getAllAccounts();

	AccountModel createAccountForCustomer(AccountModel accountModel);
	
	ApiResponseModel deleteAllAccountsByCustomerId(Long customerId);

}
