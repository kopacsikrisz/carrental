package com.kopacsi.dtos;

import java.util.Set;

import com.kopacsi.entities.BookingEntity;

public class CarDTO {

	private Integer carId;

	private String carBrand;

	private String carType;

	private Integer yearBuilt;

	private String carCondition;

	private String vehicleIdNumber;

	private String color;

	private Integer mass;

	private Set<BookingEntity> bookings;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Integer getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public String getCarCondition() {
		return carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}

	public String getVehicleIdNumber() {
		return vehicleIdNumber;
	}

	public void setVehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public Set<BookingEntity> getBookings() {
		return bookings;
	}

	public void setBookings(Set<BookingEntity> bookings) {
		this.bookings = bookings;
	}

}
