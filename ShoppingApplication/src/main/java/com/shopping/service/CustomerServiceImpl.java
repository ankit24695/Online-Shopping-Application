package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.CustomerException;
import com.shopping.module.Customer;
import com.shopping.module.CustomerDTO;
import com.shopping.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerDTO addCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findByEmail(customer.getEmail());
		
		if(opt.isPresent()) {
			throw new CustomerException("Customer already exist with this email id");
		}
		Customer addedCustomer = customerDao.save(customer);
		CustomerDTO customerDto = new CustomerDTO(addedCustomer.getFirstName(), addedCustomer.getLastName(), addedCustomer.getMobileNumber());
		
		return customerDto;
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			Customer updatedCustomer = customerDao.save(customer);
			
			CustomerDTO customerDto = new CustomerDTO(updatedCustomer.getFirstName(), updatedCustomer.getLastName(), updatedCustomer.getMobileNumber());
			return customerDto;
			
		}
		else {
			throw new CustomerException("No customer exist with this id");
		}
		
		
	}

	@Override
	public CustomerDTO removeCustomer(String email) throws CustomerException {
		 
		Optional<Customer> opt = customerDao.findByEmail(email);
		
		if(opt.isPresent()) {
			Customer deletedCustomer = opt.get();
			customerDao.delete(deletedCustomer);
			CustomerDTO customerDto = new CustomerDTO(deletedCustomer.getFirstName(), deletedCustomer.getLastName(), deletedCustomer.getMobileNumber());
			return customerDto;
		}
		else {
			throw new CustomerException("No customer exist with this email id");
		}
			
	}

	@Override
	public CustomerDTO viewCustomer(String email) throws CustomerException {
        
		Optional<Customer> opt = customerDao.findByEmail(email);
		
		if(opt.isPresent()) {
			Customer viewedCustomer = opt.get();
			CustomerDTO customerDto = new CustomerDTO(viewedCustomer.getFirstName(), viewedCustomer.getLastName(), viewedCustomer.getMobileNumber());
			return customerDto;
		}
		else {
			throw new CustomerException("No customer exist with this email id");
		}
	}

	@Override
	public List<CustomerDTO> viewAllCustomer() throws CustomerException {
		
		List<Customer> list = customerDao.findAll();
		
		if(list.size()==0) {
			throw new CustomerException("Customer list is empty..");
		}
		
		List<CustomerDTO> newlist = new ArrayList<>();
		for(Customer cust:list) {
			CustomerDTO customerDto = new CustomerDTO(cust.getFirstName(), cust.getLastName(), cust.getMobileNumber());
			newlist.add(customerDto);
		}
		return newlist;
	}

	
	
	
}
