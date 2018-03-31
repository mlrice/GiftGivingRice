package test;

import java.util.List;

import controller.GiftHelper;
import model.Gift;


public class ViewAllGiftsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GiftHelper gifthelp = new GiftHelper();
		List<Gift> allGifts = gifthelp.showAllGifts();
		for (Gift gh : allGifts) {
			System.out.println(gh.returnGiftDetails());
		}

		
	}

}
