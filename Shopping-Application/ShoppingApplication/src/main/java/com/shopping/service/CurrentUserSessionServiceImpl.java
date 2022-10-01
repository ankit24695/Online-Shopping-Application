package com.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.LoginException;
import com.shopping.module.CurrentUserSession;
import com.shopping.module.Customer;
import com.shopping.repository.CurrentUserSessionDao;
import com.shopping.repository.CustomerDao;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService{
    
	@Autowired
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException {
          Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		
		if(currentUser.isPresent()) {
			return currentUser.get();
		}
		else {
			throw new LoginException("UnAuthorized");
		}
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LoginException {
		 Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		 if(currentUser.isPresent()) {
				return currentUser.get().getId();
			}
			else {
				throw new LoginException("UnAuthorized");
			}
	}

	@Override
	public Customer getCustomerDetails(String key) {
		 Optional<CurrentUserSession> currentUser = cusDao.findByUuid(key);
		 if(currentUser.isPresent()) {
			Integer signUpUserId = 	currentUser.get().getUserId();
			 return (customerDao.findById(signUpUserId)).get();
			}
			else {
				return null;
			}
		 
		
	}
	
	
	



	
	
}
