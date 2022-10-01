package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.shopping.module.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer>{

	 
		@Query("select c from OrderProduct c where c.orderId=?1")
		public List<OrderProduct> getByOrderId(Integer orderId);
	
}
