package com.customer.dao;

import com.customer.entity.CustomerEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
	private Long id;
    private Long customerId;
    private Double balance;
    private String accountType;
    private String accountNumber;
    private CustomerEntity customer; 
}
