package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

import model.user.User;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import xmlTransformations.XMLCollectionReader;
import xquery.Util;
import xquery.Util.ConnectionProperties;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
		for (User user : users) {
			if(user.getUsername().equals(username)&&
					user.getPassword().equals(password))
			{
				request.getSession().setAttribute("currentUser", user);
				
				DatabaseClient client ;
				ConnectionProperties props = Util.loadProperties();
				if (props.database.equals("")) {
					client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
				} else {
					client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
				}
				request.getSession().setAttribute("client", client);
				
				
				ServletContext context = getServletContext();
				XMLCollectionReader xmlCollection = new XMLCollectionReader();
				xmlCollection.readDocuments(client);
				
				context.setAttribute("usvojeniAkti", xmlCollection.getUsvojeniAkti());
				context.setAttribute("aktiUproceduri", xmlCollection.getAktiUproceduri());
				context.setAttribute("amandmani", xmlCollection.getAmandmani());
				
				
				switch(user.getRole()){
					case "Predsednik": {
						response.sendRedirect("HomePagePresident.jsp");
						break;
					}
					case "Odbornik":{
						response.sendRedirect("HomePageAlderman.jsp");
						break;
					}
					case "Gradjanin":{
						response.sendRedirect("HomePageCitizen.jsp");
						break;
					}
					default:{
						response.sendRedirect("LoginPage.jsp");
					}
				}
			return;
			}
		}
		response.sendRedirect("LoginPage.jsp");
	}

}
