package com.everis.security.car.boundary;

import java.util.List;
import javax.inject.Inject;
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



/**
 * Enterprise Java Beans(EJB) CarResource.java. Clase en java donde mapeamos
 * los métodos implementados en CarService.java.
 * @author jgalvego
 *
 */
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
	@Path("prueba/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarbyCountry(@PathParam("country") String country) {
		List<Car> brands = carService.getCarbyCountry(country);
		return Response.status(Status.OK).entity(brands).build();
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCar(@PathParam("id") Long id) {
		Car carRemoved = this.carService.deleteCar(id);
		return Response.status(Status.OK).entity(carRemoved).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car){
		Car carCreated = this.carService.createCar(car);
		return Response.status(Status.CREATED).entity(carCreated).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCar(Car car) {
		Car updatedCar = this.carService.updateCar(car);
		return Response.status(Status.CREATED).entity(updatedCar).build(); // Código de respuesta: 201 Created La solicitud ha 
		//tenido éxito y se ha creado un nuevo recurso como resultado de ello. 
		//Ésta es típicamente la respuesta enviada después de una petición PUT.
	}
	
}
