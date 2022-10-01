package com.shopping.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.LoginException;
import com.shopping.module.LoginData;
import com.shopping.service.LoginService;




@RestController
public class LoginController {
    @Autowired
	private LoginService loginservice;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginData logindata) throws LoginException{
		
		String loginMessage = loginservice.logInAccount(logindata);
		
		return new ResponseEntity<>(loginMessage, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam("key") String key) throws LoginException{
		
		System.out.println(key);
		
		String logoutMessage = loginservice.logOutFromAccount(key);
		
		
		return new ResponseEntity<>(logoutMessage, HttpStatus.OK);
	}
	
}
