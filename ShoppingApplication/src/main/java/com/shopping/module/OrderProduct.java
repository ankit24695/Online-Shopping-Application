package com.shopping.module;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.GeneratedValue;

@Entity
@Data
public class OrderProduct {
    
	@Id
	@GeneratedValue
	private Integer Id;
	
    private Integer orderId;
	
	private Integer productId;
	
	private Integer quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(Integer orderId, Integer productId, Integer quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
	
}
