package com.kopacsi.carservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kopacsi.business.CarRentalManager;
import com.kopacsi.dtos.BookingRequestDTO;
import com.kopacsi.dtos.CarDTO;
import com.kopacsi.dtos.CarListDTO;
import com.kopacsi.utilities.InvalidCountryException;
import com.kopacsi.utilities.InvalidDateException;

@Path("/rental")
public class CarRentalServiceImpl implements CarRentalService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCars() {
		CarRentalManager manager = new CarRentalManager();
		
		List<CarListDTO> cars = manager.listCars();

		return Response.ok(cars).build();
	}

	@GET
	@Path("/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarDetails(@PathParam("carId") Integer carId) {
		CarRentalManager manager = new CarRentalManager();
		
		CarDTO carDetail = manager.getCarDetails(carId);

		return Response.ok(carDetail).build();
	}

	@POST
	@Path("/book")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response bookCar(BookingRequestDTO bookingDTO) throws InvalidDateException, InvalidCountryException {
		CarRentalManager manager = new CarRentalManager();
		
		manager.bookCar(bookingDTO);

		return Response.ok().build();
	}

}
