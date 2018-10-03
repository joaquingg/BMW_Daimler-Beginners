package com.everis.security.car.entity;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import com.everis.security.car.converter.LocalDateTimeAttributeConverter;

/**
 * Esta clase nos permite definir objetos de tipo coche, caracterizados
 * por una id (única para cada coche), marca, ciudadm fecha de registro, 
 * creación y última actualización.
 * @author jgalvego
 *
 */
@Entity
@Table(name="CAR")
@NamedNativeQueries(value= {
		@NamedNativeQuery(name=Car.NAMED_QUERY_ALL,query="SELECT * FROM CAR",
				resultClass=Car.class),
		
})
@NamedQueries(value= {
		@NamedQuery(name=Car.NAMED_QUERY_COUNTRY,query="SELECT c FROM Car c WHERE c.country = :country")
})

public class Car {

	public static final String NAMED_QUERY_ALL = "CochesBD";
	public static final String NAMED_QUERY_COUNTRY = "CochesBrand";
	
	//-- ATRIBUTOS --
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=false, nullable = false)
	private String brand;
	@Column(unique=false, nullable=false)
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	private LocalDateTime registro;
	@Column(unique=false,nullable=false)
	private String country;
	@Column(unique=false,nullable=false)
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	private LocalDateTime creacion;
	@Column(unique=false,nullable=false)
	@Convert(converter=LocalDateTimeAttributeConverter.class)
	private LocalDateTime last_update;

	
	// -- MÉTODOS --
	
	/**
	 * Método GET para el parámetro id
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Método SET para el parámetro id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Método GET para el parámetro Brand
	 * @return brand: marca del coche
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Método SET para el parámetro Brand
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Método GET para la fecha de registro del coche
	 * @return registro
	 */
	public LocalDateTime getRegistro() {
		return registro;
	}
	
	/**
	 * Método SET para la fecha de registro del coche
	 * @param registro
	 */
	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}
	
	/**
	 * Método GET para la ciudad
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Método SET para la ciudad
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Método GET para la fecha de creación del coche
	 * @return creacion
	 */
	public LocalDateTime getCreacion() {
		return creacion;
	}
	
	/**
	 * Método SET para la fecha de creación del coche
	 * @param creacion
	 */
	public void setCreacion(LocalDateTime creacion) {
		this.creacion = creacion;
	}
	
	/**
	 * Método GET para la fecha de última actualización del coche
	 * @return last_update
	 */
	public LocalDateTime getLast_update() {
		return last_update;
	}
	
	/**
	 * Método SET para la fecha de última actualización del coche
	 * @param last_update
	 */
	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
	
	/**
	 * Método que actualiza los parámetros característicos de un coche.
	 * Le pasamos como parámetro el coche a actualizar.
	 * @param car
	 */
	public void update(Car car) {
		this.brand = car.getBrand();
		this.registro = car.getRegistro();
		this.country = car.getCountry();
		this.creacion = car.getCreacion();
		this.last_update = car.getLast_update();
	}

	
	
	
	
	
	
}
