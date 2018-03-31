package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Occasion;

public class OccasionHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public int lookupOccasion(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Occasion> typedQuery = em
				.createQuery("select oi from Occasion oi where oi.occasionName = :selectedType", Occasion.class);
		typedQuery.setParameter("selectedType", toFind);
		typedQuery.setMaxResults(1);
		Occasion foundOccasion = typedQuery.getSingleResult();
		em.close();
		int id = foundOccasion.getId();
		return id;
	}

	public String lookupOccasionName(Integer i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Occasion> typedQuery = em.createQuery("select oi from Occasion oi where oi.id = :selectedType",
				Occasion.class);
		typedQuery.setParameter("selectedType", i);
		typedQuery.setMaxResults(1);
		Occasion foundOccasion = typedQuery.getSingleResult();
		em.close();
		String name = foundOccasion.getOccasionName();
		return name;
	}
}
