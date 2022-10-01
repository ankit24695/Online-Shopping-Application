package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.CustomerException;
import com.shopping.exception.ProductException;
import com.shopping.module.AdminProductDto;
import com.shopping.module.Customer;
import com.shopping.module.Product;
import com.shopping.module.ProductDTO;
import com.shopping.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
    
	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private CurrentUserSessionService cusService;
	
	@Override
	public AdminProductDto addProduct(AdminProductDto product, String key) throws CustomerException {
		 Customer customer = cusService.getCustomerDetails(key);
			
			if(customer==null) {
				throw new CustomerException("Please login to add the product");
			}
			
			if(!customer.getRole().toUpperCase().equals("ADMIN")) {
				throw new CustomerException("you are not authorized to add the product");
			}
		Product productDb = new Product();
		BeanUtils.copyProperties(product, productDb);
		Product newproduct =productdao.save(productDb);
		product.setProductId(newproduct.getProductId());
		return product;
	}

	@Override
	public AdminProductDto updateProduct(AdminProductDto product,String key) throws ProductException, CustomerException {
		
      Customer customer = cusService.getCustomerDetails(key);
		
		if(customer==null) {
			throw new CustomerException("Please login to add the product");
		}
		
		if(!customer.getRole().toUpperCase().equals("ADMIN")) {
			throw new CustomerException("you are not authorized to update the product");
		}
		
		Optional<Product> optProduct = productdao.findById(product.getProductId());
		
		if(!optProduct.isPresent()) {
			throw new ProductException("There is no product with this id");
		}
		
		Product productDb = new Product();
		BeanUtils.copyProperties(product, productDb);
		Product newproduct =productdao.save(productDb);
		product.setProductId(newproduct.getProductId());
		return product;
	}

	@Override
	public ProductDTO removeProduct(Integer productId,String key) throws ProductException, CustomerException {
		 Customer customer = cusService.getCustomerDetails(key);
			
			if(customer==null) {
				throw new CustomerException("Please login to add the product");
			}
			
			if(!customer.getRole().toUpperCase().equals("ADMIN")) {
				throw new CustomerException("you are not authorized to remove the product");
			}
		
		Optional<Product> optProduct = productdao.findById(productId);
		
		if(!optProduct.isPresent()) {
			throw new ProductException("There is no product with this id");
		}
		
		Product product = optProduct.get();
		productdao.delete(product);
		ProductDTO productdto = new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
		return productdto;
	}

	@Override
	public ProductDTO viewProduct(Integer productId) throws ProductException {
		 Optional<Product> optProduct = productdao.findById(productId);
			
			if(!optProduct.isPresent()) {
				throw new ProductException("There is no product with this id");
			}
			
			Product product = optProduct.get();
			ProductDTO productdto = new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
			return productdto;
	}

	@Override
	public List<ProductDTO> viewProductByCategory(String category) throws ProductException {
		
		List<Product> list = productdao.findByCategory(category);
		
		if(list.size()==0) {
			throw new ProductException("There is no product with this category");
		}
		
		List<ProductDTO> productByCategory = new ArrayList<>();
		for(Product product:list) {
			ProductDTO productdto = new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
		    productByCategory.add(productdto);
		}
		return productByCategory;
	}

	@Override
	public List<ProductDTO> viewAllProduct() throws ProductException {
		
		
     List<Product> list = productdao.findAll();
		
		if(list.size()==0) {
			throw new ProductException("There is no product to show");
		}
		
		List<ProductDTO> productByCategory = new ArrayList<>();
		for(Product product:list) {
			ProductDTO productdto = new ProductDTO(product.getProductId(), product.getProductName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
		    productByCategory.add(productdto);
		}
		return productByCategory;
	}

}
