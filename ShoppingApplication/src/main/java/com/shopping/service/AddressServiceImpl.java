package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.AddressException;
import com.shopping.module.Address;
import com.shopping.module.Customer;
import com.shopping.repository.AddressDao;
import com.shopping.repository.CustomerDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Address addAddress(Address address) {


	  Address newAddress=addressDao.save(address);
	  
	  return newAddress;
		
		
	}

	@Override
	public Address updateAddress(Address address) throws AddressException{


		Optional<Address> newAddress=addressDao.findById(address.getAddressId());
		
		if(!newAddress.isPresent()) {
		
			throw new AddressException("Address not found for updation"); 
		
		}
		
		return addressDao.save(newAddress.get());
		
		
	}


	@Override
	public List<Address> viewAllAddress() throws AddressException {

        List<Address> list=addressDao.findAll();
        
        
        if(list.size()==0) {
        	
        	throw new AddressException("No Address found"); 
        }
		
		return list;
	}

	@Override
	public Address viewAddress(Integer customerId) throws AddressException{

        
		Optional<Customer> customer= customerDao.findById(customerId);
		
		if(!customer.isPresent()) {
			
			throw new AddressException("No customer found with id : "+customerId);
		}
		
		
	 Customer newCustomer=	customer.get();
	 
	 return newCustomer.getAddress();
		
		
	}

}
