package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrowseSearchServlet
 */
public class BrowseSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowseSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sadrzaj = request.getParameter("sadrzaj");
		String naziv = request.getParameter("imeAkta");
		String predlozio = request.getParameter("predlozio");
		Date datumPredOd;
		Date datumPredDo;
		Date datumOdbOd;
		Date datumOdbDo;
		Date datumUsvOd;
		Date datumUsvDo;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		
		String datumPredlaganjaOd= request.getParameter("datumPredlaganjaOd");
			
		try {
			datumPredOd = format.parse(datumPredlaganjaOd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String datumPredlaganjaDo= request.getParameter("datumPredlaganjaDo");
		try {
			datumPredDo = format.parse(datumPredlaganjaDo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String datumOdbijanjaOd= request.getParameter("datumOdbijanjaOd");
		try {
			datumOdbOd = format.parse(datumOdbijanjaOd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String datumOdbijanjaDo= request.getParameter("datumOdbijanjaDo");
		try {
			datumOdbDo = format.parse(datumOdbijanjaDo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String datumUsvajanjaOd= request.getParameter("datumUsvajanjaOd");
		try {
			datumUsvOd = format.parse(datumUsvajanjaOd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String datumUsvajanjaDo= request.getParameter("datumUsvajanjaDo");
		try {
			datumUsvDo = format.parse(datumUsvajanjaDo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
