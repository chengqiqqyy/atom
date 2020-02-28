package app.converter;

import javax.persistence.AttributeConverter;

import app.enumeration.SexEnum;

public class SexConverter implements AttributeConverter<SexEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(SexEnum sex) {
		return sex.getId();
	}

	@Override
	public SexEnum convertToEntityAttribute(Integer id) {
		return SexEnum.getEnumById(id);
	}
	
}
