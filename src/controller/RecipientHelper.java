package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Recipient;


public class RecipientHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void deleteRecipient(Recipient toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Recipient> typedQuery = em.createQuery("select recipienthelp from Recipient recipienthelp where recipienthelp.id = :selectedId", Recipient.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		Recipient result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Recipient getRecipientById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Recipient foundItem = em.find(Recipient.class, idToEdit);
		em.close();
		return foundItem;
	}
	public List<Recipient> showAllRecipients() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Recipient> allResults = em.createQuery("select recipienthelp from Recipient recipienthelp", Recipient.class);
		List<Recipient> allRecipients = allResults.getResultList();
		em.close();
		return allRecipients;
	}

}
