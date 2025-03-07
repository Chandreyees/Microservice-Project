package com.account.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.account.dao.CustomerDao;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService {
	
	@GetMapping("/customers/{customerId}")
    CustomerDao getCustomerDao(@PathVariable Long customerId);

}
