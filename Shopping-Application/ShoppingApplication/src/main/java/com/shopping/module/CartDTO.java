package com.shopping.module;

import java.util.List;

public class CartDTO {

	private Integer cartId;
	
	private String customerName;
	
	private List<ProductDTO> list;
	
	

	public CartDTO() {
		super();
	}



	public CartDTO(Integer cartId, String customerName, List<ProductDTO> list) {
		super();
		this.cartId = cartId;
		this.customerName = customerName;
		this.list = list;
	}



	public Integer getCartId() {
		return cartId;
	}



	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public List<ProductDTO> getList() {
		return list;
	}



	public void setList(List<ProductDTO> list) {
		this.list = list;
	}
	
	
	
	
	
}
