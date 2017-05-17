package com.kopacsi.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAR_ID")
	private Integer carId;

	@Column(name = "CAR_BRAND")
	private String carBrand;

	@Column(name = "CAR_TYPE")
	private String carType;

	@Column(name = "YEAR_BUILT")
	private Integer yearBuilt;

	@Column(name = "CAR_CONDITION")
	private String carCondition;

	@Column(name = "VEHICLE_ID_NUMBER")
	private String vehicleIdNumber;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "MASS")
	private Integer mass;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bookingId")
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
