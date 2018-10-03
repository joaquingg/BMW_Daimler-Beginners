package com.everis.security.car.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locData) {
		if(locData != null) {
			return Timestamp.valueOf(locData);
		}else {
			return null;
		}
	}
	
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		if(sqlTimestamp != null) {
			return sqlTimestamp.toLocalDateTime();
		}else {
			return null;
		}
	}

}