package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter
public class RelationshipConverterInterface implements AttributeConverter<String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		// TODO Auto-generated method stub
		RelationshipHelper reh = new RelationshipHelper();
		int id = reh.lookupRelationship(attribute);
		return id;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		// TODO Auto-generated method stub
		RelationshipHelper reh = new RelationshipHelper();
		String name = reh.lookupRelationshipName(dbData);
		return name;
	}
	

}