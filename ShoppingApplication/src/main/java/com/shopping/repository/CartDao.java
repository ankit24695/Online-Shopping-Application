package com.shopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.module.Cart;
import com.shopping.module.Customer;


public interface CartDao extends JpaRepository<Cart, Integer>{

	
	public Optional<Cart> findByCustomer(Customer customer);
	
	
}
