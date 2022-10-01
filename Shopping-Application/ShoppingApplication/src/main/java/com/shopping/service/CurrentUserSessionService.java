package com.shopping.service;

import com.shopping.exception.LoginException;
import com.shopping.module.CurrentUserSession;
import com.shopping.module.Customer;

public interface CurrentUserSessionService {

	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;
	public Integer getCurrentUserSessionId(String key) throws LoginException;
	
	public Customer getCustomerDetails(String key);
	
}
