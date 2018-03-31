package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanTFConverterInterface implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		// TODO Auto-generated method stub
		if (Boolean.TRUE.equals(attribute))
			return "Yes";
		else
			return "No";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return "Yes".equals(dbData);
	}

}
