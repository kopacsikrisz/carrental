package com.kopacsi.dtos;

import java.util.List;

import com.kopacsi.utilities.CarUsage;

public class BookingRequestDTO {

	private Integer carId;

	private String bookDateFrom;

	private String bookDateTo;

	private CarUsage carUsage;

	private List<String> countries;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getBookDateFrom() {
		return bookDateFrom;
	}

	public void setBookDateFrom(String bookDateFrom) {
		this.bookDateFrom = bookDateFrom;
	}

	public String getBookDateTo() {
		return bookDateTo;
	}

	public void setBookDateTo(String bookDateTo) {
		this.bookDateTo = bookDateTo;
	}

	public CarUsage getCarUsage() {
		return carUsage;
	}

	public void setCarUsage(CarUsage carUsage) {
		this.carUsage = carUsage;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

}
