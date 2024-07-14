package com.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customer.model.ApiResponseModel;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseModel> handleCustomerNotFoundException(ResourceNotFoundException ex) {
        ApiResponseModel apiResponseModel = ApiResponseModel.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiResponseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseModel> handleGlobalException(Exception ex) {
        ApiResponseModel apiResponseModel = ApiResponseModel.builder().message(ex.getMessage()).success(true).status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return new ResponseEntity<>(apiResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}