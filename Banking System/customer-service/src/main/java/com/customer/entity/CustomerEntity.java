package com.customer.entity;

import java.util.List;

import com.customer.dao.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerEntity {
	
	@Id
	private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    @Transient
    private List<Account> accounts;
}
