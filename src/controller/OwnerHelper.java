/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

/**
 * @author 3li
 *
 */
public class OwnerHelper {
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("PetsWeek3");

	public void insertOwner(Owner o) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	public List<Owner> showAllOwners() {
		EntityManager em = emfac.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
		return allOwners;
	}

	public Owner findShopper(String nameToLookUp) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.ownerName = :selectedName",
				Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Owner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new Owner(nameToLookUp);
		}
		em.close();
		return foundOwner;
	}
}
