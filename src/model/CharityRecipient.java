package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "charity")
@DiscriminatorValue("c")

public class CharityRecipient extends Recipient {
	
	@Column(name = "tax_id")
	private String taxID;
	
	
	


	public CharityRecipient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CharityRecipient(String name, String streetAddress, String city, String state, String postalCode,
			String taxID) {
		super(name, streetAddress, city, state, postalCode);
		this.taxID = taxID;
	}


	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	@Override
	public String toString() {
		return "charityRecipient [taxID=" + taxID + ", toString()=" + super.toString() + "]";
	}
	
	
	
		
}
