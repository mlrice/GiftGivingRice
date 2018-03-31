package test;

import controller.RecipientHelper;
import model.Recipient;


public class DeleteRecipientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RecipientHelper recipienthelp = new RecipientHelper();
		Recipient IPTV = recipienthelp.getRecipientById(18);
		recipienthelp.deleteRecipient(IPTV);
	

	}

}
