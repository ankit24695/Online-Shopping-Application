package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.CustomerException;
import com.shopping.exception.ProductException;
import com.shopping.module.Cart;
import com.shopping.module.CartDTO;
import com.shopping.module.CartProduct;
import com.shopping.module.Customer;
import com.shopping.module.Product;
import com.shopping.module.ProductDTO;
import com.shopping.repository.CartDao;
import com.shopping.repository.CartProductDao;
import com.shopping.repository.ProductDao;

@Service
public class CartServiceImpl implements CartService{
    
	@Autowired
	private CurrentUserSessionService cusService;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartProductDao cartProductdao;
	
	
	@Override
	public CartDTO addProduct(Integer productId, Integer quantity,String key) throws CustomerException, ProductException  {
		
		Customer customer = cusService.getCustomerDetails(key);
		
		if(customer==null) {
			throw new CustomerException("Please login to add the product to cart");
		}
		
		Optional<Product> optproduct = productDao.findById(productId);
		
		if(!optproduct.isPresent()) {
			
			throw new ProductException("Product Not found with this id");
		}
		Product product = optproduct.get();
		
		if(product.getQuantity()<quantity) {
			throw new ProductException("Product is out of stock");
		}
		product.setQuantity(product.getQuantity()-quantity);

		Optional<Cart> optcart = cartDao.findByCustomer(customer);
		
		if(optcart.isPresent()) {

			 Cart cart = optcart.get();
			 
			 CartProduct cartProduct = new CartProduct(cart.getCartId(), product.getProductId(), quantity);
			
			 cartProductdao.save(cartProduct);
			 
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 for(CartProduct cartprod: list) {
				 Product prod = productDao.findById(cartprod.getProductId()).get();
				 ProductDTO prodDTO = new ProductDTO(prod.getProductId(), prod.getProductName(), prod.getPrice(), cartprod.getQuantity(), prod.getPrice()*cartprod.getQuantity());
			     listofproduct.add(prodDTO);
			 }
			 CartDTO cartdto = new CartDTO(cart.getCartId(), cart.getCustomer().getFirstName(), listofproduct);
			 productDao.save(product);
			 return cartdto;
			 
		}
		else {
			Cart newcart = new Cart();
			newcart.setCustomer(customer);
			Cart cart = cartDao.save(newcart);
			
			 CartProduct cartProduct = new CartProduct(cart.getCartId(), product.getProductId(), quantity);
				
			 cartProductdao.save(cartProduct);
			
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 for(CartProduct cartprod: list) {
				 Product prod = productDao.findById(cartprod.getProductId()).get();
				 ProductDTO prodDTO = new ProductDTO(prod.getProductId(), prod.getProductName(), prod.getPrice(), cartprod.getQuantity(), prod.getPrice()*cartprod.getQuantity());
			     listofproduct.add(prodDTO);
			 }
			 CartDTO cartdto = new CartDTO(cart.getCartId(), cart.getCustomer().getFirstName(), listofproduct);
			 productDao.save(product);
			 return cartdto;
		}
		
		
	}

	@Override
	public CartDTO removeProduct(String key, Integer productId) throws CustomerException, ProductException {
        
		Customer customer = cusService.getCustomerDetails(key);
		
		if(customer==null) {
			throw new CustomerException("Please login to remove the product from cart");
		}
		
		Optional<Product> optproduct = productDao.findById(productId);
		
		if(!optproduct.isPresent()) {
			
			throw new ProductException("There is no product with this id");
		}
		Product product = optproduct.get();
		
		Optional<Cart> optcart = cartDao.findByCustomer(customer);
		
		if(optcart.isPresent()) {
			 Cart cart = optcart.get();
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 boolean flag=true;
			 for(CartProduct cartprod: list) {
				 if(cartprod.getProductId()==productId) {
					 flag=false;
					 cartProductdao.delete(cartprod);
					 product.setQuantity(product.getQuantity()+cartprod.getQuantity());
					 productDao.save(product);
					 break;
				 }
			 }
			 if(flag) {
				 throw new ProductException("There was no product in your cart with this id: "+" "+productId);
			 }
			 
			 List<CartProduct> listtwo = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 for(CartProduct cartprod: listtwo) {
				 Product prod = productDao.findById(cartprod.getProductId()).get();
				 ProductDTO prodDTO = new ProductDTO(prod.getProductId(), prod.getProductName(), prod.getPrice(), cartprod.getQuantity(), prod.getPrice()*cartprod.getQuantity());
			     listofproduct.add(prodDTO);
			 }
			 CartDTO cartdto = new CartDTO(cart.getCartId(), cart.getCustomer().getFirstName(), listofproduct);
			 return cartdto;
		}
		else{
			throw new ProductException("You have no product to remove from your cart");
		}
		
		
	}

	@Override
	public CartDTO updateProductQuantity(String key, Integer productId, Integer quantity) throws CustomerException, ProductException {

        Customer customer = cusService.getCustomerDetails(key);
		
		if(customer==null) {
			throw new CustomerException("Please login to update the product in cart");
		}
		
		Optional<Product> optproduct = productDao.findById(productId);
		
		if(!optproduct.isPresent()) {
			
			throw new ProductException("Product Not found with this id");
		}
		Product product = optproduct.get();
		
		if(product.getQuantity()<quantity) {
			throw new ProductException("Product is out of stock");
		}
		product.setQuantity(product.getQuantity()-quantity);
		
		
		Optional<Cart> optcart = cartDao.findByCustomer(customer);
		
		if(optcart.isPresent()) {
			 Cart cart = optcart.get();
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 boolean flag=true;
			 for(CartProduct cartprod: list) {
				 if(cartprod.getProductId()==productId) {
					 flag=false;
					 cartprod.setQuantity(cartprod.getQuantity()+quantity);
					 productDao.save(product);
					 cartProductdao.save(cartprod);
					 break;
				 }
			 }
			 if(flag) {
				 throw new ProductException("There was no product in your cart with this id: "+" "+productId);
			 }
			 
			 List<CartProduct> listtwo = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 for(CartProduct cartprod: listtwo) {
				 Product prod = productDao.findById(cartprod.getProductId()).get();
				 ProductDTO prodDTO = new ProductDTO(prod.getProductId(), prod.getProductName(), prod.getPrice(), cartprod.getQuantity(), prod.getPrice()*cartprod.getQuantity());
			     listofproduct.add(prodDTO);
			 }
			 CartDTO cartdto = new CartDTO(cart.getCartId(), cart.getCustomer().getFirstName(), listofproduct);
			 return cartdto;
		}
		else{
			throw new ProductException("You have no product in the cart to update the quantity");
		}
	
	}

	@Override
	public CartDTO removeAllProduct(String key) throws CustomerException, ProductException {
        
		Customer customer = cusService.getCustomerDetails(key);
		
		if(customer==null) {
			throw new CustomerException("Please login to remove all the product from your cart");
		}
		
		Optional<Cart> optcart = cartDao.findByCustomer(customer);
		
		if(optcart.isPresent()) {
			 Cart cart = optcart.get();
			 
			 
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 if(list.size()==0) {
				 throw new ProductException("Your cart is already empty...");
			 }
			 for(CartProduct cartprod: list) {
				 Product product = productDao.findById(cartprod.getProductId()).get();
				 product.setQuantity(product.getQuantity()+cartprod.getQuantity());
				 cartProductdao.delete(cartprod);
				 productDao.save(product);
			 }
			 
			 List<CartProduct> listtwo = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 CartDTO cartdto = new CartDTO(cart.getCartId(), cart.getCustomer().getFirstName(), listofproduct);
			 return cartdto;
			 
		}
		else{
			throw new ProductException("You dont have anything in your cart to remove..");
		}

	}

	@Override
	public List<ProductDTO> viewAllProduct(String key) throws CustomerException, ProductException {
       Customer customer = cusService.getCustomerDetails(key);
       if(customer==null) {
			throw new CustomerException("Please login to view all the product in your cart");
		}
       
       Optional<Cart> optcart = cartDao.findByCustomer(customer);
		
		if(optcart.isPresent()) {
			 Cart cart = optcart.get();
			 
			 
			 List<CartProduct> list = cartProductdao.getByCartId(cart.getCartId());
			 List<ProductDTO> listofproduct = new ArrayList<>();
			 for(CartProduct cartprod: list) {
				 Product prod = productDao.findById(cartprod.getProductId()).get();
				 ProductDTO prodDTO = new ProductDTO(prod.getProductId(), prod.getProductName(), prod.getPrice(), cartprod.getQuantity(), prod.getPrice()*cartprod.getQuantity());
			     listofproduct.add(prodDTO);
			 }
			return listofproduct; 
		}
		else{
			throw new ProductException("You dont have anything in your cart");
		}
	}



}
