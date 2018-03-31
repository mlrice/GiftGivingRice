package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "recipient_type")
@DiscriminatorValue(value = "r")
@Table(name = "recipient")

public class Recipient {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id")
			private int id;
			@Column(name = "name")
			private String name;
			@Column(name = "address")
			private String streetAddress;
			@Column(name = "city")
			private String city;
			@Column(name = "state")
			private String state;
			@Column(name = "postal_code")
			private String postalCode;
		
			
			
			
			
			public Recipient() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
			
			public Recipient(String name, String streetAddress, String city, String state,
					String postalCode) {
				this.name = name;
				this.streetAddress = streetAddress;
				this.city = city;
				this.state = state;
				this.postalCode = postalCode;
			}


			public Recipient(int id) {
				super();
				this.id = id;
			}

			public Recipient(String name) {
				super();
				this.name = name;
			}



			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getStreetAddress() {
				return streetAddress;
			}
			public void setStreetAddress(String streetAddress) {
				this.streetAddress = streetAddress;
			}
		
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getPostalCode() {
				return postalCode;
			}
			public void setPostalCode(String postalCode) {
				this.postalCode = postalCode;
			}



			@Override
			public String toString() {
				return "Recipient [name=" + name + ", streetAddress=" + streetAddress  + ", city="
						+ city + ", state=" + state + ", postalCode=" + postalCode + "]";
			}



			public Object getId() {
				// TODO Auto-generated method stub
				return id;
			}



			public String returnRecipientDetails() {
				// TODO Auto-generated method stub
				return name;
			}
			
			
			

}
