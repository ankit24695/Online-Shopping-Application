package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.module.Customer;
import com.shopping.module.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

	public List<Order> findByCustomers(Customer customers);
}
