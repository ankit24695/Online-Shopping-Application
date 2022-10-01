package com.shopping.module;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
    
    @NotNull(message = "Street Number cannot be left blank")
	private String streetNo;
	
    private String buildingName;
	
    @NotNull(message = "City name cannot be left blank")
	private String city;
	
    @NotNull(message = "State name cannot be left blank")
	private String state;
	
    @NotNull(message = "Country name cannot be left blank")
	private String country;
	
    @NotNull(message = "pincode cannot be left blank")
	private String pincode;
	
	
	
	public Address() {
		
	}



	public Address(Integer addressId, String streetNo, String buildingName, String city, String state, String country,
			String pincode) {
		super();
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}



	public Integer getAddressId() {
		return addressId;
	}



	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}



	public String getStreetNo() {
		return streetNo;
	}



	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}



	public String getBuildingName() {
		return buildingName;
	}



	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
