package com.shopping.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionhandler(LoginException le, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(le.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productExceptionhandler(ProductException pe, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(pe.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> orderExceptionhandler(AddressException ae, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ae.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> addressExceptionhandler(OrderException oe, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(oe.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionhandler(CustomerException ce, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ce.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodargExceptionhandler(MethodArgumentNotValidException me){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation error");
		error.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionhandler(Exception ee, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ee.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
