package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Gift;

public class GiftHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void deleteGift(Gift toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Gift> typedQuery = em.createQuery("select gifthelp from Gift gifthelp where gifthelp.id = :selectedId", Gift.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Gift result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Gift getGiftById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Gift foundItem = em.find(Gift.class, idToEdit);
		em.close();
		return foundItem;
	}
	public List<Gift> showAllGifts() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Gift> allResults = em.createQuery("select gifthelp from Gift gifthelp", Gift.class);
		List<Gift> allGifts = allResults.getResultList();
		em.close();
		return allGifts;
	}



	
	
}
