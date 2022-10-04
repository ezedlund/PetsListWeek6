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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditListDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListItemHelper lih = new ListItemHelper();
		OwnerHelper oh = new OwnerHelper();

		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);

		String newListName = request.getParameter("listName");
		String ownerName = request.getParameter("ownerName");
		Owner newOwner = oh.findShopper(ownerName);

		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<PetItem> selectedItemsInList = new ArrayList<PetItem>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				PetItem c = lih.searchForPetById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfItems(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<PetItem> selectedItemsInList = new ArrayList<PetItem>();
			listToUpdate.setListOfItems(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setOwner(newOwner);

		ldh.updateList(listToUpdate);

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
