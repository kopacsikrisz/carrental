package com.kopacsi.dtos;

import java.time.LocalDate;

import com.kopacsi.entities.CarEntity;

public class BookingDTO {

	private Integer bookingId;

	private LocalDate bookingDateFrom;

	private LocalDate bookingDateTo;

	private CarEntity car;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public LocalDate getBookingDateFrom() {
		return bookingDateFrom;
	}

	public void setBookingDateFrom(LocalDate bookingDateFrom) {
		this.bookingDateFrom = bookingDateFrom;
	}

	public LocalDate getBookingDateTo() {
		return bookingDateTo;
	}

	public void setBookingDateTo(LocalDate bookingDateTo) {
		this.bookingDateTo = bookingDateTo;
	}

}
