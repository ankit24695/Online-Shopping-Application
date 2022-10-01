package com.shopping.service;

import java.util.List;

import com.shopping.exception.CustomerException;
import com.shopping.exception.OrderException;
import com.shopping.module.OrderDTO;

public interface OrderService {

	public OrderDTO addOrder(String key) throws OrderException, CustomerException;
	
	public OrderDTO viewOrder(String key, Integer orderId) throws OrderException, CustomerException;
	
	public List<OrderDTO> listOfOrder(String key) throws OrderException, CustomerException;
	
	public List<OrderDTO> listOfOrderByCustomerId(Integer customerId)throws OrderException, CustomerException;
	
	
	
}
