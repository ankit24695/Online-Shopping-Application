package com.shopping.module;

import lombok.Data;

@Data
public class AdminProductDto {
	
	private Integer productId;
	private String productName;
	private double price;
	private String color;
	private String dimension;
	private String specification;
	private String manufacturer;
	private Integer quantity;
	private String category;

}
