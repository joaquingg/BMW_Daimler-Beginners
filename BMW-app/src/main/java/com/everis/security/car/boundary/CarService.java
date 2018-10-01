package com.everis.security.car.boundary;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.everis.security.car.entity.Car;
import com.everis.security.car.exceptions.CarNotFoundException;



@Stateless
@ManagedBean(name="carService")
public class CarService {

	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<Car> getCars() {
		
		CriteriaBuilder builder = em.getCriteriaBuilder(); // BUILDER --> CriteriaBuilder
		CriteriaQuery<Car> query = builder.createQuery(Car.class); // QUERY --> CriteriaQuery
		
		query.select(query.from(Car.class)); // SELECT * FROM cars
		List<Car> carsFound = (List<Car>) em.createQuery(query).getResultList();
		if(carsFound == null || carsFound.isEmpty()) {
			return new LinkedList<>(); // LISTA VACÍA EN CASO DE NO ENCONTRAR NADA
		}
		
		return carsFound;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public Car getCar(Long id) throws CarNotFoundException{
		Car c = em.find(Car.class, id);
		if(c == null) {
			throw new CarNotFoundException("Coche no encontrado");
		}
		return c;
	}
	
	
	public Car deleteCar(Long id) {
		Car cRemoved = this.getCar(id);
		this.em.remove(cRemoved);
		return cRemoved;
	}
	
	
	public Car createCar(Car car){

			this.em.persist(car);
			this.em.flush();
			this.em.refresh(car);
		
			
		return car;
	}
	
	
	public Car updateCar(Car car) {
		Car updatedCar = this.getCar(car.getId());
		updatedCar.update(car);
		return updatedCar;
		
	}
	
	
	
	
	
	
	
}
