package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Owner;
import model.PetItem;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper lih = new ListItemHelper();
		String listName = request.getParameter("listName");
		System.out.println("List name: "+ listName);
		String ownerName=request.getParameter("ownerName");
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<PetItem> selectedItemsInList = new ArrayList<PetItem>();
		// check for something selected
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				PetItem c = lih.searchForPetById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		Owner owner = new Owner(ownerName);
		ListDetails ld = new ListDetails(listName, owner);
		ld.setListOfItems(selectedItemsInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(ld);
		
		System.out.println("Success");
		System.out.println(ld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
