package com.shopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.module.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer>{

	public Optional<Customer> findByEmail(String email);
}
