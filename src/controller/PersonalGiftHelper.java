package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gift;
import model.PersonalGift;


public class PersonalGiftHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void addPersonalGift(PersonalGift toAdd) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PersonalGift> showAllPersonalGifts() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<PersonalGift> allResults = em.createQuery("select pgifthelp from PersonalGift pgifthelp", PersonalGift.class);
		List<PersonalGift> allPersonalGifts = allResults.getResultList();
		em.close();
		return allPersonalGifts;
	}

	public Object getGifts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteGift(PersonalGift giftToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonalGift> typedQuery = em.createQuery("select pg from PersonalGift pg where pg.id = :selectedId",
				PersonalGift.class);
		typedQuery.setParameter("selectedId", giftToDelete.getId());
		typedQuery.setMaxResults(1);
		Gift result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PersonalGift getGiftById(Integer i) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PersonalGift foundGift = em.find(PersonalGift.class, i);
		em.close();
		return foundGift;
	
	}

	public void editGift(PersonalGift toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	}
	

			

