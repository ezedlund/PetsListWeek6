/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * @author 3li
 *
 */
public class ListDetailsHelper {
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("PetsWeek3");

	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListDetails> getLists() {
		EntityManager em = emfac.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(ListDetails toDelete) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em
				.createQuery("select detail from ListDetails detail where detail.id = :selectedId", ListDetails.class);

		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		// save
		ListDetails result = typedQuery.getSingleResult();
		// remove
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(ListDetails toEdit) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
