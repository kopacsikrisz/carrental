package com.kopacsi.utilities;

import com.kopacsi.dtos.CarDTO;
import com.kopacsi.dtos.CarListDTO;
import com.kopacsi.entities.CarEntity;

public class CarEntityMapper {

	public static CarDTO toDTO(CarEntity entity) {
		CarDTO dto = new CarDTO();
		
		if (entity == null) {
			return dto;
		}
		
		dto.setBookings(entity.getBookings());
		dto.setCarBrand(entity.getCarBrand());
		dto.setCarCondition(entity.getCarCondition());
		dto.setCarId(entity.getCarId());
		dto.setCarType(entity.getCarType());
		dto.setColor(entity.getColor());
		dto.setMass(entity.getMass());
		dto.setVehicleIdNumber(entity.getVehicleIdNumber());
		dto.setYearBuilt(entity.getYearBuilt());
		
		return dto;
	}
	
	public static CarListDTO toListDTO(CarEntity entity) {
		CarListDTO dto = new CarListDTO();
		
		if (entity == null) {
			return dto;
		}
		
		dto.setCarBrand(entity.getCarBrand());
		dto.setCarId(entity.getCarId());
		dto.setCarType(entity.getCarType());
		dto.setYearBuilt(entity.getYearBuilt());
		
		return dto;
	}
	
}
