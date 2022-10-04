/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

/**
 * @author 3li
 *
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<PetItem> listOfItems;

	public ListDetails() {
		super();
	}

	public ListDetails(int id, String listName, Owner owner, List<PetItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.owner = owner;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, Owner owner, List<PetItem> listOfItems) {
		super();
		this.listName = listName;
		this.owner = owner;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, Owner owner) {
		super();
		this.listName = listName;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<PetItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<PetItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", owner=" + owner + ", listOfItems="
				+ listOfItems.toString() + "]";
	}

}
