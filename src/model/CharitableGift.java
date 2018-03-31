package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import controller.BooleanTFConverterInterface;

@Entity
@Table(name = "gift")
@DiscriminatorValue("c")

public class CharitableGift extends Gift {

	@Column(name = "tax_deductible")
	@Convert(converter = BooleanTFConverterInterface.class)
	private boolean isTaxDeductible;
	@Convert(converter = BooleanTFConverterInterface.class)
	@Column(name = "have_receipt")
	private boolean haveReceipt;
	
	
	
	public CharitableGift() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CharitableGift(LocalDate dateGiven, String description, double value, Recipient recipient,
			boolean isTaxDeductible, boolean haveReceipt) {
		super(dateGiven, description, value, recipient);
		this.isTaxDeductible = isTaxDeductible;
		this.haveReceipt = haveReceipt;
	}
	
	
	public boolean isTaxDeductible() {
		return isTaxDeductible;
	}
	public void setTaxDeductible(boolean isTaxDeductible) {
		this.isTaxDeductible = isTaxDeductible;
	}
	public boolean isHaveReceipt() {
		return haveReceipt;
	}
	public void setHaveReceipt(boolean haveReceipt) {
		this.haveReceipt = haveReceipt;
	}
	
	
	@Override
	public String toString() {
		return "CharitableGift [isTaxDeductible=" + isTaxDeductible + ", haveReceipt=" + haveReceipt + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
