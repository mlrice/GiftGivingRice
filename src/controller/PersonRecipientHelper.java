package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PersonRecipient;

public class PersonRecipientHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void addPersonRecipient(PersonRecipient toAdd) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteRecipient(PersonRecipient toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonRecipient> typedQuery = em.createQuery(
				"select pr from PersonRecipient pr where pr.id = :selectedId",PersonRecipient.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		PersonRecipient result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PersonRecipient getRecipientById(int i) {
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		PersonRecipient foundRecipient = em.find(PersonRecipient.class, i);
		em.close();
		return foundRecipient;
	}
	public void editRecipient (PersonRecipient toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PersonRecipient> getRecipients() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonRecipient> typedQuery = em.createQuery("select pr from PersonRecipient pr",
				PersonRecipient.class);
		List<PersonRecipient> personList = typedQuery.getResultList();
		em.close();
		return personList;
	}
	
			
}


