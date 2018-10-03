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
 * por una id (�nica para cada coche), marca, ciudadm fecha de registro, 
 * creaci�n y �ltima actualizaci�n.
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

	
	// -- M�TODOS --
	
	/**
	 * M�todo GET para el par�metro id
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * M�todo SET para el par�metro id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * M�todo GET para el par�metro Brand
	 * @return brand: marca del coche
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * M�todo SET para el par�metro Brand
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * M�todo GET para la fecha de registro del coche
	 * @return registro
	 */
	public LocalDateTime getRegistro() {
		return registro;
	}
	
	/**
	 * M�todo SET para la fecha de registro del coche
	 * @param registro
	 */
	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}
	
	/**
	 * M�todo GET para la ciudad
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * M�todo SET para la ciudad
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * M�todo GET para la fecha de creaci�n del coche
	 * @return creacion
	 */
	public LocalDateTime getCreacion() {
		return creacion;
	}
	
	/**
	 * M�todo SET para la fecha de creaci�n del coche
	 * @param creacion
	 */
	public void setCreacion(LocalDateTime creacion) {
		this.creacion = creacion;
	}
	
	/**
	 * M�todo GET para la fecha de �ltima actualizaci�n del coche
	 * @return last_update
	 */
	public LocalDateTime getLast_update() {
		return last_update;
	}
	
	/**
	 * M�todo SET para la fecha de �ltima actualizaci�n del coche
	 * @param last_update
	 */
	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
	
	/**
	 * M�todo que actualiza los par�metros caracter�sticos de un coche.
	 * Le pasamos como par�metro el coche a actualizar.
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
