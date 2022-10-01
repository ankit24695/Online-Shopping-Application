package com.shopping.service;

import com.shopping.exception.LoginException;
import com.shopping.module.LoginData;

public interface LoginService {

	public String logInAccount(LoginData loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
	
}
