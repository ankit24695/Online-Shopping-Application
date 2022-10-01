package com.shopping.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "cart_product")
@Entity
@Data
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer cartId;
	
	private Integer productId;
	
	private Integer quantity;

	public CartProduct() {
		super();
	}

	public CartProduct(Integer cartId, Integer productId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
}
