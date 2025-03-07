package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.dao.AccountModel;
import com.account.dao.TransactionRequest;
import com.account.dao.ApiResponseModel;
import com.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel> getAccountModelById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountDetails(id));
    }

    @PostMapping("/add-money")
    public ResponseEntity<ApiResponseModel> addMoneyToAccountModel(@RequestBody TransactionRequest model) {
        return ResponseEntity.ok(accountService.addMoneyToAccount(model));
    }

    @PostMapping("/withdraw-money")
    public ResponseEntity<AccountModel> withdrawMoneyFromAccountModel(@RequestBody TransactionRequest model) {
        AccountModel updatedAccountModel = accountService.withdrawMoneyFromAccount(model);
        return ResponseEntity.ok(updatedAccountModel);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountModel>> getAllAccountModels() {
        List<AccountModel> AccountModels = accountService.getAllAccounts();
        return ResponseEntity.ok(AccountModels);
    }
    
    @PostMapping("/create-account")
    public ResponseEntity<AccountModel> createAccountForCustomer(@RequestBody AccountModel accountModel) {
        AccountModel createdAccount = accountService.createAccountForCustomer(accountModel);
        return ResponseEntity.ok(createdAccount);
    }
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponseModel> deleteAccountModel(@PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.deleteAllAccountsByCustomerId(customerId));
    }
}

