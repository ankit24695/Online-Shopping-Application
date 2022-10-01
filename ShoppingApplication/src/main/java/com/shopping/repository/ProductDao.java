package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.module.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
    
	public List<Product> findByCategory(String category);
}
