package com.everis.security.car.boundary;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.everis.security.car.entity.Car;




@Path("coches")
public class CarResource {

	@Inject
	private CarService carService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars() {
		List<Car> carsFound = carService.getCars();
		return Response.status(Status.OK).entity(carsFound).build();

	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCar(@PathParam("id") Long id) {
		Car car = this.carService.getCar(id);
		return Response.status(Status.OK).entity(car).build();

	}	
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCar(@PathParam("id") Long id) {
		Car carRemoved = this.carService.deleteCar(id);
		return Response.status(Status.OK).entity(carRemoved).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCar(Car car){
		Car carCreated = this.carService.createCar(car);
		return Response.status(Status.CREATED).entity(carCreated).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCar(Car car) {
		Car updatedCar = this.carService.updateCar(car);
		return Response.status(Status.OK).entity(updatedCar).build();
	}
	
}
