package test;

import controller.GiftHelper;
import model.Gift;


public class DeleteGiftTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GiftHelper gifthelp = new GiftHelper();
		Gift gift3 = gifthelp.getGiftById(9);
		gifthelp.deleteGift(gift3);
	
	}

}
