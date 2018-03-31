package test;

import controller.CharitableGiftHelper;
import controller.CharitableRecipientHelper;
import model.CharitableGift;
import model.CharityRecipient;

public class AddCharitableGiftTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CharitableRecipientHelper crecipienthelp = new CharitableRecipientHelper();
		CharitableGiftHelper cgifthelper = new CharitableGiftHelper();
		CharityRecipient FreeToBreathe = new CharityRecipient("Free To Breathe", "100 Main St.", "Des Moines", "IA", "50310", "123456789");
		crecipienthelp.addRecipient(FreeToBreathe);
		
		CharitableGift ftb = new CharitableGift("10/8/17", "money", 100.00 , FreeToBreathe, true, true);
		cgifthelper.addGift(ftb);
		
	}

}
