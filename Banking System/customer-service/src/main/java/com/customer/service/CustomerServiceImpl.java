package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer.entity.CustomerEntity;
import com.customer.exceptions.CustomerServiceException;
import com.customer.exceptions.ResourceNotFoundException;
import com.customer.external.service.AccountService;
import com.customer.model.ApiResponseModel;
import com.customer.model.CustomerDao;
import com.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
	private AccountService accountService;

    @Override
    public List<CustomerDao> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::convertToModel).toList();
    }

    @Override
    public ApiResponseModel addCustomer(CustomerDao customer) {
    	CustomerEntity customerEntity = CustomerEntity.builder().id(customer.getId()).name(customer.getName())
    						.email(customer.getEmail()).phoneNumber(customer.getPhoneNumber()).build();
        customerRepository.save(customerEntity);
       return ApiResponseModel.builder().message("Created").success(true).status(HttpStatus.CREATED).build();
    }

    @Override
    public CustomerDao getCustomerById(Long id) {
        return customerRepository.findById(id).map(this::convertToModel)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public ApiResponseModel deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
        ApiResponseModel apiResponseModel = accountService.deleteAccount(id);
        if (apiResponseModel.getStatus().is2xxSuccessful()) {
            log.info("Account deleted successfully!!!");
        } else {
           log.error("Failed to delete account");
           throw new CustomerServiceException("Failed to delete accounts");
        }
        
        return ApiResponseModel.builder().message("Deleted").success(true).status(HttpStatus.OK).build();
    }

    @Override
    public ApiResponseModel updateCustomer(Long id, CustomerDao customer) {
        CustomerEntity existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(existingCustomer);
        return ApiResponseModel.builder().message("Updated").success(true).status(HttpStatus.OK).build();
    }
    
    private CustomerDao convertToModel(CustomerEntity entity) {
    	return CustomerDao.builder().name(entity.getName()).email(entity.getEmail())
    			.phoneNumber(entity.getPhoneNumber()).id(entity.getId()).build();
    }

}
