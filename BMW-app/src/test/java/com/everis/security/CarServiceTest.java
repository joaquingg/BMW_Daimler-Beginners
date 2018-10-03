package com.everis.security;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.security.car.boundary.CarService;
import com.everis.security.car.entity.Car;
import com.everis.security.car.exceptions.CarNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
	
	@InjectMocks
	CarService carService;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void testGetCarsOK() {
		List<Car> cars_esperada = new LinkedList<>();
		cars_esperada.add(new Car());
		
		when(em.createNamedQuery(Car.NAMED_QUERY_ALL)).thenReturn(query);
		when(query.getResultList()).thenReturn(cars_esperada); // Preparamos nuestra prueba de tal manera que cuando se ejecute nuestro
		// método a probar, la lista actual sea nuestra lista esperada
		
		List<Car> cars_actual = carService.getCars();
		assertEquals(1,cars_actual.size());
		
	}
	
	@Test
	public void testGetCarsEmpty() {
		List<Car> cars_esperada = new LinkedList<>();
		
		when(em.createNamedQuery(Car.NAMED_QUERY_ALL)).thenReturn(query);
		when(query.getResultList()).thenReturn(cars_esperada); // Preparamos nuestra prueba de tal manera que cuando se ejecute nuestro
		// método a probar, la lista actual sea nuestra lista esperada
		
		List<Car> cars_actual = carService.getCars();
		assertEquals(0,cars_actual.size());
		
	}
	
	@Test
	public void testGetCarOK() {
		Car carEsperado = new Car();
		when(em.find(Matchers.anyObject(), Matchers.anyLong())).thenReturn(carEsperado);
		
		Car carActual = carService.getCar(201L);
		assertEquals(carEsperado,carActual);
		
	}
	
	@Test(expected=CarNotFoundException.class)
	public void testGetCarNULL() {
		Car carEsperado = new Car();
		when(em.find(Matchers.anyObject(), Matchers.anyLong())).thenReturn(null);
		
		Car carActual = carService.getCar(201L);
		
	}
	
	@Test
	public void testGetCarByCountry() {
		List<Car> cars_esperada = new LinkedList<>();
		cars_esperada.add(new Car());
		when(em.createNamedQuery(Car.NAMED_QUERY_COUNTRY)).thenReturn(query);
		when(query.getResultList()).thenReturn(cars_esperada); // Preparamos nuestra prueba de tal manera que cuando se ejecute nuestro
		// método a probar, la lista actual sea nuestra lista esperada
		
		List<Car> cars_actual = carService.getCarbyCountry("londres");
		assertEquals(1,cars_actual.size());
	}
	
	@Test
	public void testGetCarByCountryNULL() {
		List<Car> cars_esperada = new LinkedList<>();
		
		when(em.createNamedQuery(Car.NAMED_QUERY_COUNTRY)).thenReturn(query);
		when(query.getResultList()).thenReturn(null); // Preparamos nuestra prueba de tal manera que cuando se ejecute nuestro
		// método a probar, la lista actual sea nuestra lista esperada
		
		List<Car> cars_actual = carService.getCarbyCountry("");
		assertEquals(0,cars_actual.size());
	}
	
	@Test
	public void testGetCarByCountryEmpty() {
		List<Car> cars_esperada = new LinkedList<>();
		
		when(em.createNamedQuery(Car.NAMED_QUERY_COUNTRY)).thenReturn(query);
		when(query.getResultList()).thenReturn(cars_esperada); // Preparamos nuestra prueba de tal manera que cuando se ejecute nuestro
		// método a probar, la lista actual sea nuestra lista esperada
		
		List<Car> cars_actual = carService.getCarbyCountry("country");
		assertEquals(0,cars_actual.size());
	}
	
	@Test
	public void testDeleteCar() {
		Car carEsperado = new Car();
		when(em.find(Matchers.anyObject(), Matchers.anyLong())).thenReturn(carEsperado);
		
		Mockito.doNothing().when(this.em).remove(carEsperado);
		this.carService.deleteCar(1L);
		Mockito.verify(this.em).remove(carEsperado);
	}
	
	@Test
	public void testCreateCar() {
		Car c = new Car();
		Mockito.doNothing().when(this.em).persist(Matchers.anyObject());
		this.carService.createCar(c);
		Mockito.verify(this.em).persist(c);
	}
	
	@Test
	public void testUpdateCar() {
		Car carEsperado = new Car();
		when(em.find(Matchers.anyObject(), Matchers.anyLong())).thenReturn(carEsperado);
		
		Mockito.doNothing().when(this.carService.updateCar(carEsperado));
		Mockito.verify(this.em).merge(carEsperado);
	}

}
