package com.kopacsi.utilities;

import com.kopacsi.dtos.BookingDTO;
import com.kopacsi.entities.BookingEntity;

public class BookingEntityMapper {
	
	public static BookingEntity toEntity(BookingDTO dto) {
		BookingEntity entity = new BookingEntity();
		
		entity.setBookingDateFrom(dto.getBookingDateFrom());
		entity.setBookingDateTo(dto.getBookingDateTo());
		entity.setCar(dto.getCar());
		
		return entity;
	}
	
	public static BookingDTO toDTO(BookingEntity entity) {
		BookingDTO dto = new BookingDTO();
		
		dto.setBookingDateFrom(entity.getBookingDateFrom());
		dto.setBookingDateTo(entity.getBookingDateTo());
		dto.setCar(entity.getCar());
		
		return dto;
	}
	
}
