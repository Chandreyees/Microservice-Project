package com.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.account.dao.ApiResponseModel;

@ControllerAdvice
public class AccountExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseModel> handleAccountNotFoundException(ResourceNotFoundException ex) {
		ApiResponseModel apiResponseModel=ApiResponseModel.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiResponseModel, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResponseModel> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		ApiResponseModel errorResponse = ApiResponseModel.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccountServiceException.class)
	public ResponseEntity<ApiResponseModel> handleRuntimeException(AccountServiceException ex) {
		ApiResponseModel errorResponse =ApiResponseModel.builder().message(ex.getMessage()).success(true).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
