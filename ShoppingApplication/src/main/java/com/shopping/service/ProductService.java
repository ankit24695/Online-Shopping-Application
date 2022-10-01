package com.shopping.service;

import java.util.List;

import com.shopping.exception.CustomerException;
import com.shopping.exception.ProductException;
import com.shopping.module.AdminProductDto;
import com.shopping.module.ProductDTO;

public interface ProductService {

	public AdminProductDto addProduct(AdminProductDto product, String key) throws CustomerException;
	
	public AdminProductDto updateProduct(AdminProductDto product,String key) throws ProductException,CustomerException;
	
	public ProductDTO removeProduct(Integer productId,String key)throws ProductException,CustomerException;
	
	public ProductDTO viewProduct(Integer productId)throws ProductException;
	
	public List<ProductDTO> viewProductByCategory(String category) throws ProductException;
	
	public List<ProductDTO> viewAllProduct() throws ProductException;
	
	
}
