package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.User;

/**
 * Servlet implementation class AddAmandman
 */
public class AddAmandman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAmandman() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("currentUser");
		String fileName = request.getParameter("fileName");
		request.setAttribute("fileName", fileName);
		
		if(user.getRole().equals("Odbornik"))
        	getServletContext().getRequestDispatcher("/AmandmentsAlderman.jsp").forward(request, response);
        else
        	getServletContext().getRequestDispatcher("/AmandmentsPresident.jsp").forward(request, response);	
	}

}
