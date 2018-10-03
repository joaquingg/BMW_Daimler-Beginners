package com.everis.security.car.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Excepci�n del tipo Mapper que nos permite mapear la excepci�n CarNotFoundException.java,
 * 
 * @author jgalvego
 *
 */
@Provider
public class CarNotFoundExceptionMapper implements ExceptionMapper<CarNotFoundException>{
	
	/**
	 * La excepci�n es lanzada cuando algun coche no es encontrado en la base de datos (error code: 404)
	 */
	@Override
	public Response toResponse(CarNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
		
}
