package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import controller.OccasionConverterInterface;

@Entity
@Table(name = "gift")
@DiscriminatorValue("p")

public class PersonalGift extends Gift {
	
	@Column(name = "occasion_id")
	@Convert(converter = OccasionConverterInterface.class)
	private String occasion;
	
	
	

	public PersonalGift(LocalDate dateGiven, String description, double value, Recipient recipient, String occasion) {
		super(dateGiven, description, value, recipient);
		this.occasion = occasion;
	}
	
	



	public PersonalGift() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	@Override
	public String toString() {
		return "PersonalGift [occasion=" + occasion + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
