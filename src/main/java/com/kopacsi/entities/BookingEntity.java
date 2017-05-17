package com.kopacsi.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bookings")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
	private Integer bookingId;

	@Column(name = "BOOKING_DATE_FROM")
	private LocalDate bookingDateFrom;

	@Column(name = "BOOKING_DATE_TO")
	private LocalDate bookingDateTo;

	@ManyToOne
	@JoinColumn(name = "CAR_ID")
	private CarEntity car;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

}
