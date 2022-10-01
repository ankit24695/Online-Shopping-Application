package com.shopping.module;

public class ProductDTO {

	private Integer productId;
	
	private String productName;
	
	private double productPrice;
	
	private Integer quantity;
	
	private double amount;
	
	

	public ProductDTO() {
		super();
	}



	public ProductDTO(Integer productId, String productName, double productPrice, Integer quantity, double amount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.amount = amount;
	}



	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}

     

	
}
