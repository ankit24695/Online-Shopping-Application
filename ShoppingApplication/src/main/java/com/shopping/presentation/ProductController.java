package com.shopping.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.CustomerException;
import com.shopping.exception.ProductException;
import com.shopping.module.AdminProductDto;
import com.shopping.module.Product;
import com.shopping.module.ProductDTO;
import com.shopping.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {
    @Autowired
	private ProductService productService;
	
    @PostMapping("/addproduct")
    public ResponseEntity<AdminProductDto> addProduct(@RequestBody AdminProductDto productDto, @RequestParam("key") String key) throws CustomerException{
    	
    	AdminProductDto addedProduct = productService.addProduct(productDto,key);
    	
    	return new ResponseEntity<AdminProductDto>(addedProduct, HttpStatus.ACCEPTED);
    	
    }
	
    
    @PutMapping("/updateproduct")
    public ResponseEntity<AdminProductDto> updateProduct(@RequestBody AdminProductDto product, @RequestParam("key") String key) throws ProductException, CustomerException{
    	
    	AdminProductDto updatedProduct = productService.updateProduct(product,key);
    	
    	return new ResponseEntity<AdminProductDto>(updatedProduct, HttpStatus.ACCEPTED);
    	
    }
    
    @DeleteMapping("/deleteproduct/{Id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("Id") Integer Id, @RequestParam("key") String key) throws ProductException, CustomerException{
    	
    	ProductDTO deletedProduct = productService.removeProduct(Id,key);
    	
    	return new ResponseEntity<ProductDTO>(deletedProduct, HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/viewproduct/{Id}")
    public ResponseEntity<ProductDTO> viewProduct(@PathVariable("Id") Integer Id) throws ProductException{
    	
    	ProductDTO viewedProduct = productService.viewProduct(Id);
    	
    	return new ResponseEntity<ProductDTO>(viewedProduct, HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/viewproductbycategory/{category}")
    public ResponseEntity<List<ProductDTO>> viewProductByCategory(@PathVariable("category") String category) throws ProductException{
    	
    	List<ProductDTO> listOfProductbyCategory = productService.viewProductByCategory(category);
    	
    	return new ResponseEntity<List<ProductDTO>>(listOfProductbyCategory, HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/viewallproduct")
    public ResponseEntity<List<ProductDTO>> viewallProduct() throws ProductException{
    	
    	List<ProductDTO> listOfProduct = productService.viewAllProduct();
    	
    	return new ResponseEntity<List<ProductDTO>>(listOfProduct, HttpStatus.OK);
    	
    }
    
    
    
    
}
