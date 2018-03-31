package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "relationship")

public class Relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private int id;
	@Column (name = "RELATIONSHIP")
	private String relationshipType;
	
	public Relationship() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Relationship(String string) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}




	public String getRelationshipType() {
		return relationshipType;
	}
	
}
