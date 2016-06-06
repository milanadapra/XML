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

import model.user.User;

/**
 * Servlet implementation class StartServlet
 */
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> users = new ArrayList<User>();
	
	private HashMap<String, String> usvojeniAkti = new  HashMap<String, String>();
	private HashMap<String, String> aktiUproceduri = new  HashMap<String, String>();
	private HashMap<String, String> amandmani = new  HashMap<String, String>();
	
       
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
		
		usvojeniAkti.put("Dusanov zakonik", "/example/akti/usvojeni/test.xml");
		usvojeniAkti.put("Zakon o radu", "/example/akti/usvojeni/zor.xml");
		usvojeniAkti.put("Zakon o policiji", "/example/akti/usvojeni/zop.xml");
	
		aktiUproceduri.put("Zakon o legalizaciji marihuane", "/example/akti/uproceduri/zolm.xml");
		
		amandmani.put("Prodaja marihuane samo u apotekama", "/example/amandmani/zaIzmjenu/a1.xml");
		amandmani.put("Prodaja marihuane samo punoletnim osobama", "/example/amandmani/zaDodati/a1.xml");
		}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext context = getServletContext();
		context.setAttribute("users", users);
		context.setAttribute("usvojeniAkti", usvojeniAkti);
		context.setAttribute("aktiUproceduri", aktiUproceduri);
		context.setAttribute("amandmani", amandmani);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("LoginPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
