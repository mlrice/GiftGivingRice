package test;

import java.time.LocalDate;

import controller.PersonRecipientHelper;
import controller.PersonalGiftHelper;
import model.PersonRecipient;
import model.PersonalGift;
import model.Recipient;

public class AddPersonalGiftTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonRecipientHelper precipienthelp = new PersonRecipientHelper();
		PersonalGiftHelper pgifthelper = new PersonalGiftHelper();
		PersonRecipient AbbyRice = new PersonRecipient("Abby Rice", "4400 92nd St.", "Urbandale", "IA", "50322", LocalDate.of(2018, 1, 7), "Daughter");
		precipienthelp.addPersonRecipient(AbbyRice);

		
		PersonalGift doll = new PersonalGift(LocalDate.of(2017, 12, 25), "test", 10.00 , AbbyRice , "Christmas");
		pgifthelper.addPersonalGift(doll);
		
	}

}