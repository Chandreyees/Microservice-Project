package com.customer.service;

import java.util.List;

import com.customer.model.ApiResponseModel;
import com.customer.model.CustomerDao;

public interface CustomerService {

	List<CustomerDao> getAllCustomers();

	ApiResponseModel addCustomer(CustomerDao customer);

	CustomerDao getCustomerById(Long id);

	ApiResponseModel deleteCustomer(Long id);

	ApiResponseModel updateCustomer(Long id, CustomerDao customer);

}
