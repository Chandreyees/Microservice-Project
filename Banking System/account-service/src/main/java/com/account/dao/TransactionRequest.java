package com.account.dao;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {

	@Nonnull
	private Long customerId;
	private Double balance;
	@Nonnull
	private String accountNumber;
}
