package com.everis.security.car.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car {

	// -- CONSTANTES
	//-- ATRIBUTOS --
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	@Column(unique=false, nullable = false)
	private String brand;
	@Column(unique=false, nullable=false)
	private Timestamp registro;
	@Column(unique=false,nullable=false)
	private String country;
	@Column(unique=false,nullable=false)
	private Timestamp creacion;
	@Column(unique=false,nullable=false)
	private Timestamp last_update;

	
	//-- MÉTODOS --
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Timestamp getRegistro() {
		return registro;
	}
	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Timestamp getCreacion() {
		return creacion;
	}
	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

	
	
	
	
	
	
}
