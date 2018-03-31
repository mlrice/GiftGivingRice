package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OccasionConverterInterface implements AttributeConverter<String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		
		OccasionHelper och = new OccasionHelper();
		int id = och.lookupOccasion(attribute);
		return id;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		
		OccasionHelper och = new OccasionHelper();
		String name = och.lookupOccasionName(dbData);
		return name;
	}

}
