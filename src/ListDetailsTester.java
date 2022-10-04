import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Owner;
import model.PetItem;

/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Oct 3, 2022
 */

/**
 * @author 3li
 *
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Owner eli = new Owner("Eli");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		List<PetItem> eliItems = new ArrayList<PetItem>();
		
		ListDetails eliList = new ListDetails("Eli's Pet List", eli);
		eliList.setListOfItems(eliItems);
		
		ldh.insertNewListDetails(eliList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}

	}

}
