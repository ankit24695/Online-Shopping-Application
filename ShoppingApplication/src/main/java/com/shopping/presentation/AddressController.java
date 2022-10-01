package com.shopping.presentation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.AddressException;
import com.shopping.module.Address;
import com.shopping.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addaddress")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address){
		
		
		Address savedAddress= addressService.addAddress(address);
		
		
		return new ResponseEntity<Address>(savedAddress, HttpStatus.ACCEPTED);
	
	}
	
	@PutMapping("/updateaddress")
	public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address address) throws AddressException{
		
		
		Address updatedAddress= addressService.updateAddress(address);
		
		
		return new ResponseEntity<Address>(updatedAddress, HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/listofaddress")
	public ResponseEntity<List<Address>> listOfAddress() throws AddressException{
		
		
		List<Address> list= addressService.viewAllAddress();
		
		
		return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
	
	}
	
	@GetMapping("/viewaddress/{customerId}")
	public ResponseEntity<Address> viewAddress(@PathVariable("customerId") Integer customerId) throws AddressException{
		
		
	    Address viewAddress= addressService.viewAddress(customerId);
		
		
		return new ResponseEntity<Address>(viewAddress, HttpStatus.OK);
	}
	
	
}
