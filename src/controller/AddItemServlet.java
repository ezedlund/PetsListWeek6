package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get owner, name, and type
		String owner = request.getParameter("owner");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		// create and save
		PetItem pet = new PetItem(owner, name, type);
		ListItemHelper dao = new ListItemHelper();
		dao.insertItem(pet);
		// return
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
