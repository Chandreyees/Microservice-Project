package com.customer.model;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseModel {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}
