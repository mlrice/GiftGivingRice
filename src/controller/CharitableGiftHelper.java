package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CharitableGift;
import model.Gift;


public class CharitableGiftHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public void addGift(CharitableGift toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CharitableGift> getGifts(){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharitableGift> typedQuery = em.createQuery(
				"select cg from CharitableGift cg", CharitableGift.class);
		List<CharitableGift> cgiftList = typedQuery.getResultList();
		em.close();
		return cgiftList;
	}

	public Object showAllCharitableGifts() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<CharitableGift> allResults = em.createQuery("select cgifthelp from CharitableGift cgifthelp", CharitableGift.class);
		List<CharitableGift> allCharitableGifts = allResults.getResultList();
		em.close();
		return allCharitableGifts;
	
	}

	public CharitableGift getGiftById(Integer i) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CharitableGift foundGift = em.find(CharitableGift.class, i);
		em.close();
		return foundGift;
	
	}

	public void deleteGift(CharitableGift giftToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharitableGift> typedQuery = em.createQuery("select cg from CharitableGift cg where cg.id = :selectedId",
				CharitableGift.class);
		typedQuery.setParameter("selectedId", giftToDelete.getId());
		typedQuery.setMaxResults(1);
		Gift result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	public void editGift(CharitableGift toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	}
	

	

