package com.customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerDao {
	private Long id;
	private String name;
    private String email;
    private String phoneNumber;

}
