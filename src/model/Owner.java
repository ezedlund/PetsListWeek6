/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String ownerName;
	public Owner() {
		super();
	}
	public Owner(int id, String ownerName) {
		super();
		this.id = id;
		this.ownerName = ownerName;
	}
	public Owner(String ownerName) {
		super();
		this.ownerName = ownerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Override
	public String toString() {
		return "Owner: [id=" + id + ", ownerName=" + ownerName + "]";
	}
	

}