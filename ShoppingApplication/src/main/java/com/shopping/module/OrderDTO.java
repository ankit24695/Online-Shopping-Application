package com.shopping.module;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Integer orderId;
	
	private String customerName;
	
	private List<ProductDTO> list;
	
	private LocalDate localdate;
	
	private Double totalAmount;
	
	

	public OrderDTO() {
		super();
	}



	



	public OrderDTO(Integer orderId, String customerName, List<ProductDTO> list, LocalDate localdate,
			Double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.list = list;
		this.localdate = localdate;
		this.totalAmount = totalAmount;
	}







	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public List<ProductDTO> getList() {
		return list;
	}



	public void setList(List<ProductDTO> list) {
		this.list = list;
	}



	public Double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}







	public LocalDate getLocaldate() {
		return localdate;
	}







	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}







	
	
	
	
}
