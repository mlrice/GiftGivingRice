package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CharityRecipient;
import model.PersonRecipient;
import model.Recipient;

public class CharitableRecipientHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void addRecipient(Recipient toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<CharityRecipient> getRecipients() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharityRecipient> typedQuery = em.createQuery("select cr from CharityRecipient cr",
				CharityRecipient.class);
		List<CharityRecipient> charityList = typedQuery.getResultList();
		em.close();
		return charityList;
	}

	public void deleteRecipient(CharityRecipient toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharityRecipient> typedQuery = em.createQuery(
				"select cr from CharityRecipient cr where dr.id = :selectedId",CharityRecipient.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		CharityRecipient result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	

	public CharityRecipient getRecipientById(int i) {
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		CharityRecipient foundRecipient = em.find(CharityRecipient.class, i);
		em.close();
		return foundRecipient;
	}
	
	public void editRecipient (CharityRecipient toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	

}
