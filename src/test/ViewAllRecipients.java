package test;

import java.util.List;

import controller.RecipientHelper;
import model.Recipient;


public class ViewAllRecipients {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RecipientHelper recipienthelp = new RecipientHelper();
		List<Recipient> allRecipients = recipienthelp.showAllRecipients();
		for (Recipient rh : allRecipients) {
			System.out.println(rh.returnRecipientDetails());
	
		
	}

	}
}
