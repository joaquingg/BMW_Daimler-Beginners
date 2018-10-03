package com.everis.security.car.boundary;


import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.everis.security.car.entity.Car;
import com.everis.security.car.exceptions.CarNotFoundException;


/**
 * Enterprise Java Beans (EJB) CarService.java. Clase en java que nos permite
 * a partir de un EntityManager crear, borrar, actualizar y buscar coches
 * almacenados en nuestra base de datos.
 * @author jgalvego
 *
 */
@Stateless
@ManagedBean(name="carService")
public class CarService {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Método que consulta una base de datos y devuelve los coches almacenados en ella. En
	 * el caso de no encontrar nada, devuelve una lista vacía.
	 * @return carsFound: Lista de objetos tipo coche encontrados en nuestra base de datos
	 */
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<Car> getCars() {
		List<Car> carsFound = (List<Car>) em.createNamedQuery(Car.NAMED_QUERY_ALL).getResultList();
		if(carsFound == null || carsFound.isEmpty()) {
			return new LinkedList<>(); // LISTA VACÍA EN CASO DE NO ENCONTRAR NADA
		}
		
		return carsFound;
	}
	
	public List<Car> getCarbyCountry(String country) {
		Query query = em.createNamedQuery(Car.NAMED_QUERY_COUNTRY);
		query.setParameter("country", country);
		List<Car> brands = (List<Car>) query.getResultList();
			if(brands == null || brands.isEmpty()) {
				return new LinkedList<>();
			}
			return brands;
	}
	
	/**
	 * Método que busca un coche por la id de este
	 * @param id: id del coche concreto que buscamos
	 * @return c: coche que buscamos
	 * @throws CarNotFoundException: en el caso de no encontrarlo lanzamos una excepción
	 */
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public Car getCar(Long id){
		Car c = em.find(Car.class, id);
		if(c == null) {
			throw new CarNotFoundException("Coche no encontrado");
		}
		return c;
	}
	
	/**
	 * Método que busca por la id un determinado coche. Lo borra 
	 * y lo devuelve.
	 * @param id: id del coche concreto que deseamos borrar
	 * @return cRemoved: coche que deseamos borrar
	 */
		
	public Car deleteCar(Long id) {
		
		Car cRemoved = this.getCar(id);
		this.em.remove(cRemoved);
		return cRemoved;
	}
	
	
	
	
	/**
	 * Método que nos crea un determinado coche
	 * @param car
	 * @return car
	 */
	public Car createCar(Car car){

			this.em.persist(car);
			this.em.flush();
			this.em.refresh(car);
		
			
		return car;
	}
	
	
	/**
	 * Método que nos actualiza un determinado coche
	 * @param car
	 * @return
	 */
	public Car updateCar(Car car) {
		Car updatedCar = this.getCar(car.getId());
		updatedCar.update(car);
		return updatedCar;
		
	}
	
	
	
	
	
	
	
}
