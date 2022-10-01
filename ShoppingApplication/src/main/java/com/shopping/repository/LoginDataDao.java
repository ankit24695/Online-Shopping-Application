package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.module.LoginData;

public interface LoginDataDao extends JpaRepository<LoginData, Integer>{

	public LoginData findByUserId(Integer userId);
	
}
