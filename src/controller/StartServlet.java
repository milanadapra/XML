package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

import model.user.User;
import xmlTransformations.XMLCollectionReader;
import xquery.Util;
import xquery.Util.ConnectionProperties;

/**
 * Servlet implementation class StartServlet
 */
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> users = new ArrayList<User>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		users.add(new User("user", "user", "Gradjanin"));
		users.add(new User("admin", "admin", "Predsednik"));
		users.add(new User("mico", "micic", "Odbornik"));
	}
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		context.setAttribute("users", users);
		context.setAttribute("usvojeniAkti", xmlCollection.getUsvojeniAkti());
		context.setAttribute("aktiUproceduri", xmlCollection.getAktiUproceduri());
		context.setAttribute("amandmani", xmlCollection.getAmandmani());
		
		response.sendRedirect("LoginPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
