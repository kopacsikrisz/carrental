package com.kopacsi.business;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.kopacsi.dao.BookingDAO;
import com.kopacsi.dao.CarDAO;
import com.kopacsi.dtos.BookingDTO;
import com.kopacsi.dtos.BookingRequestDTO;
import com.kopacsi.dtos.CarDTO;
import com.kopacsi.dtos.CarListDTO;
import com.kopacsi.entities.BookingEntity;
import com.kopacsi.entities.CarEntity;
import com.kopacsi.mock.ExternalMockService;
import com.kopacsi.utilities.BookingEntityMapper;
import com.kopacsi.utilities.CarEntityMapper;
import com.kopacsi.utilities.CarUsage;
import com.kopacsi.utilities.InvalidCountryException;
import com.kopacsi.utilities.InvalidDateException;

public class CarRentalManager {
	
	public List<CarListDTO> listCars() {
		CarDAO carDAO = new CarDAO();
		
		List<CarListDTO> carList = carDAO.listCars()
				.stream()
				.map(car -> CarEntityMapper.toListDTO(car))
				.collect(Collectors.toList());

		return carList;
	}
	
	public CarDTO getCarDetails(Integer carId) {
		CarDAO carDAO = new CarDAO();
		
		CarDTO carDetail = CarEntityMapper.toDTO(carDAO.getCarDetails(carId));

		return carDetail;
	}
	
	public BookingDTO bookCar(BookingRequestDTO bookingRequestDTO) throws InvalidDateException, InvalidCountryException {
		BookingDAO bookingDAO = new BookingDAO();
		
		LocalDate from = LocalDate.parse(bookingRequestDTO.getBookDateFrom());
		LocalDate to = LocalDate.parse(bookingRequestDTO.getBookDateTo());
		
		List<BookingEntity> bookingsForInterval = bookingDAO.bookingsForInterval(from, to);
		
		if (!bookingsForInterval.isEmpty()) {
			throw new InvalidDateException();
		}
		
		CarDAO carDAO = new CarDAO();
		
		CarEntity car = carDAO.getCarDetails(bookingRequestDTO.getCarId());
		
		validateCarUsage(bookingRequestDTO, car);
		
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setBookingDateFrom(from);
		bookingEntity.setBookingDateTo(to);
		bookingEntity.setCar(car);
		bookingDAO.persist(bookingEntity);
		
		return BookingEntityMapper.toDTO(bookingEntity);
	}
	
	private void validateCarUsage(BookingRequestDTO bookingRequestDTO, CarEntity car) throws InvalidCountryException {
		if (bookingRequestDTO.getCarUsage() == CarUsage.FOREIGN) {
			if (bookingRequestDTO.getCountries().isEmpty()) {
				throw new InvalidCountryException("In case of foreign car usage, target countries must be specified.");
			}

			boolean validCountry = ExternalMockService.checkCarUsageForCountry(car.getCarType(), bookingRequestDTO.getCountries());
			
			if (!validCountry) {
				throw new InvalidCountryException("Given car type cannot be used in target country.");
			}
		}
	}

}
