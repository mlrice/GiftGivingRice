package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import controller.DateConverterInterface;
import controller.RelationshipConverterInterface;

@Entity
@Table(name = "person")
@DiscriminatorValue("p")

public class PersonRecipient extends Recipient {
	
	@Column(name = "birth_date")
	@Convert(converter = DateConverterInterface.class)
	private LocalDate birthDate;
	@Column(name = "relationship")
	@Convert(converter = RelationshipConverterInterface.class)
	private String relationship;
	
	
	
	public PersonRecipient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PersonRecipient(String name, String streetAddress, String city, String state,
			String postalCode, LocalDate birthDate, String relationship) {
		super(name, streetAddress, city, state, postalCode);
		this.birthDate = birthDate;
		this.relationship = relationship;
	}
	
	public PersonRecipient(int id) {
		super(id);
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	
	@Override
	public String toString() {
		return "PersonRecipient [birthDate=" + birthDate + ", relationship=" + relationship + ", toString()="
				+ super.toString() + "]";
	}
	
	public String PRecipientDetails() {
		return "ID:" + getId() + "  NAME:" + getName() + "  STREET ADDRESS:" + getStreetAddress() + "  CITY:" + getCity() + "  STATE:" + getState() + "  POSTALCODE:" + getPostalCode() + "  BIRTHDATE:" + birthDate + "  RELATIONSHIP:" + relationship;
	}
	
}
