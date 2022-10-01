package com.shopping.service;

import java.util.List;

import com.shopping.exception.CustomerException;
import com.shopping.module.Customer;
import com.shopping.module.CustomerDTO;


public interface CustomerService {

	public CustomerDTO addCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO updateCustomer(Customer customer) throws CustomerException;
	
	public CustomerDTO removeCustomer(String email) throws CustomerException;
	
	public CustomerDTO viewCustomer(String email) throws CustomerException;
	
	public List<CustomerDTO> viewAllCustomer() throws CustomerException;
	
	
}
