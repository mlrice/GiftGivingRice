package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Relationship;

public class RelationshipHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRice");

	public int lookupRelationship(String toFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Relationship> typedQuery = em.createQuery(
				"select ri from Relationship ri where ri.relationshipType = :selectedType", Relationship.class);
		typedQuery.setParameter("selectedType", toFind);
		typedQuery.setMaxResults(1);
		Relationship foundRelationship = typedQuery.getSingleResult();
		em.close();
		int id = foundRelationship.getId();
		return id;
	}

	public String lookupRelationshipName(Integer i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Relationship> typedQuery = em
				.createQuery("select ri from Relationship ri where ri.id = :selectedType", Relationship.class);
		typedQuery.setParameter("selectedType", i);
		typedQuery.setMaxResults(1);
		Relationship foundRelationship = typedQuery.getSingleResult();
		em.close();
		String name = foundRelationship.getRelationshipType();
		return name;
	}

}
