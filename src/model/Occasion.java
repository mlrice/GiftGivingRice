package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "occasion")
public class Occasion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "OCCASION")
	private String occasionName;

	public Occasion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occasion(String occasionName) {
		super();
		this.occasionName = occasionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOccasionName() {
		return occasionName;
	}

	public void setOccassionName(String occasionName) {
		this.occasionName = occasionName;
	}

}
