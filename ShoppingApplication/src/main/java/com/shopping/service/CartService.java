package com.shopping.service;

import java.util.List;

import com.shopping.exception.CustomerException;
import com.shopping.exception.ProductException;
import com.shopping.module.Cart;
import com.shopping.module.CartDTO;
import com.shopping.module.ProductDTO;

public interface CartService {

	public CartDTO addProduct(Integer productId, Integer quantity,String key) throws CustomerException, ProductException;
	
	public CartDTO removeProduct(String key, Integer productId) throws CustomerException, ProductException;
	
	public CartDTO updateProductQuantity(String key, Integer productId, Integer quantity) throws CustomerException, ProductException;
	
	public CartDTO removeAllProduct(String key) throws CustomerException, ProductException;
	
	public List<ProductDTO> viewAllProduct(String key) throws CustomerException, ProductException;
	
}
