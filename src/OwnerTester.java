import java.util.List;

import controller.OwnerHelper;
import model.Owner;

/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */

/**
 * @author 3li
 *
 */
public class OwnerTester {

	public static void main(String[] args) {
		Owner eli = new Owner("Eli");
		Owner eli2 = new Owner("Eli2");
		
		OwnerHelper oh = new OwnerHelper();
		
		oh.insertOwner(eli);
		oh.insertOwner(eli2);
		
		List<Owner> allOwners = oh.showAllOwners();
		for (Owner o : allOwners) {
			System.out.println(o.toString());
		}

	}

}
