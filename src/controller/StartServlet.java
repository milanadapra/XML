package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Akt;
import model.Amandman;
import model.User;

/**
 * Servlet implementation class StartServlet
 */
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> users = new ArrayList<User>();
	
	private ArrayList<Akt> usvojeniAkti = new ArrayList<Akt>();
	private ArrayList<Akt> aktiUproceduri = new ArrayList<Akt>();
	private ArrayList<Amandman> amandmani = new ArrayList<Amandman>();
	
       
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
		users.add(new User("devojka", "123", "Gradjanin"));
		users.add(new User("admin", "admin", "Predsednik"));
		users.add(new User("mico", "micic", "Odbornik"));
		
		usvojeniAkti.add(new Akt("Akt o preduzetnistvu","12/5/2012"));
		usvojeniAkti.add(new Akt("Akt o radu","14/2/2008"));
		usvojeniAkti.add(new Akt("Akt o maloletnickom prestupnistvu","31/1/2005"));
	
		aktiUproceduri.add(new Akt("Akt o legalizaciji prostitucije","5/5/2016"));
		aktiUproceduri.add(new Akt("Akt o legalizaciji marihuane","2/3/2015"));
		
		amandmani.add(new Amandman(usvojeniAkti.get(0), "Neka izmjena", "jer mi se hoce", users.get(2)));
		amandmani.add(new Amandman(usvojeniAkti.get(2), "U zatvor poslati", "jer su djubrad", users.get(0)));
		amandmani.add(new Amandman(aktiUproceduri.get(0), "Moraju imati ljekarsko uvjerenje", "Zdravlje na prvom mjestu", users.get(2)));
		amandmani.add(new Amandman(aktiUproceduri.get(1), "Prodaja samo u trafikama", "Zasto bilo gdje drugo", users.get(0)));
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
