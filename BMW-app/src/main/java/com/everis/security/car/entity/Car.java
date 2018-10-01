package com.everis.security.car.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CAR")
public class Car {

	// -- CONSTANTES
	//-- ATRIBUTOS --
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=false, nullable = false)
	private String brand;
	@Column(unique=false, nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	@Column(unique=false,nullable=false)
	private String country;
	@Column(unique=false,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creacion;
	@Column(unique=false,nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;

	
	//-- MÉTODOS --
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getRegistro() {
		return registro;
	}
	public void setRegistro(Date registro) {
		this.registro = registro;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
	public void update(Car car) {
		this.brand = car.getBrand();
		this.registro = car.getRegistro();
		this.country = car.getCountry();
		this.creacion = car.getCreacion();
		this.last_update = car.getLast_update();
	}

	
	
	
	
	
	
}
