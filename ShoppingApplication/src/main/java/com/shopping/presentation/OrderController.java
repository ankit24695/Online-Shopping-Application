package com.shopping.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.exception.OrderException;
import com.shopping.module.OrderDTO;
import com.shopping.service.OrderService;

@RestController
public class OrderController {
    
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/placeorder")
	public ResponseEntity<OrderDTO> placeOrder(@RequestParam("key") String key) throws OrderException, CustomerException{
		
		OrderDTO orderDto = orderService.addOrder(key);
		
		return new ResponseEntity<OrderDTO>(orderDto, HttpStatus.ACCEPTED);
		
	}
	
	 @GetMapping("/vieworder/{Id}")
     public ResponseEntity<OrderDTO> viewOrder(@RequestParam("key") String key, @PathVariable("Id") Integer Id) throws OrderException, CustomerException{
		
		OrderDTO orderDto = orderService.viewOrder(key,Id);
		
		return new ResponseEntity<OrderDTO>(orderDto, HttpStatus.ACCEPTED);
		
	} 
	 
	 @GetMapping("/viewallorder")
     public ResponseEntity<List<OrderDTO>> viewOrder(@RequestParam("key") String key) throws OrderException, CustomerException{
		
		List<OrderDTO> orderDto = orderService.listOfOrder(key);
		
		return new ResponseEntity<List<OrderDTO>>(orderDto, HttpStatus.OK);
		
	} 
	 
	 
	 @GetMapping("/vieworderbycustomerid/{Id}")
     public ResponseEntity<List<OrderDTO>> viewAllOrderById(@RequestParam("key") String key, @PathVariable("Id") Integer Id) throws OrderException, CustomerException{
		
		    List<OrderDTO> orderDto = orderService.listOfOrderByCustomerId(Id);
			
			return new ResponseEntity<List<OrderDTO>>(orderDto, HttpStatus.OK);
		
	} 
	 
	 
	 
	
	
	
}
