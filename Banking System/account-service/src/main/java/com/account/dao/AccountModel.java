package com.account.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModel {

	private Long customerId;
	private String accountNumber;
	private Double balance;
	private String accountType;
	private CustomerDao customerDetails;
}
