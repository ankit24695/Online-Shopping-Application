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
import com.shopping.module.CartDTO;
import com.shopping.module.ProductDTO;
import com.shopping.service.CartService;

@RestController
public class CartController {
    
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/addtocart/{productID}/{quantity}")
	public ResponseEntity<CartDTO> addToCart(@RequestParam("key") String key,@PathVariable("productID") Integer productId, @PathVariable("quantity") Integer quantity) throws CustomerException, ProductException {
		
		CartDTO cartDto=cartService.addProduct(productId, quantity,key);
		
		return new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/deletefromcart/{productId}")
	public ResponseEntity<CartDTO> deletefromCart(@RequestParam("key") String key, @PathVariable("productId") Integer productId) throws CustomerException, ProductException{
		
       CartDTO cartDto=cartService.removeProduct(key, productId);
		
		return new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
		
	}
	
	@PutMapping("/updatecart/{productID}/{quantity}")
	public ResponseEntity<CartDTO> updateCart(@RequestParam("key") String key,@PathVariable("productID") Integer productId, @PathVariable("quantity") Integer quantity) throws CustomerException, ProductException {
		
		CartDTO cartDto=cartService.updateProductQuantity(key, productId, quantity);
		
		return new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteallfromcart")
	public ResponseEntity<CartDTO> deleteAllItemCart(@RequestParam("key") String key) throws CustomerException, ProductException{
		
       CartDTO cartDto=cartService.removeAllProduct(key);
		
		return new ResponseEntity<CartDTO>(cartDto, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewallproductfromcart")
	public ResponseEntity<List<ProductDTO>> viewallProduct(@RequestParam("Key") String key) throws CustomerException, ProductException{
		
		List<ProductDTO> list = cartService.viewAllProduct(key);
		
		return new ResponseEntity<List<ProductDTO>>(list, HttpStatus.OK);
	}
	
	
}
