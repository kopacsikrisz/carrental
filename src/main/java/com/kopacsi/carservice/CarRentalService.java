package com.kopacsi.carservice;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.kopacsi.dtos.BookingRequestDTO;
import com.kopacsi.utilities.InvalidCountryException;
import com.kopacsi.utilities.InvalidDateException;


public interface CarRentalService {

	public Response listCars();

	public Response getCarDetails(@PathParam("carId") Integer carId);

	public Response bookCar(BookingRequestDTO bookingDTO) throws InvalidDateException, InvalidCountryException;

}
