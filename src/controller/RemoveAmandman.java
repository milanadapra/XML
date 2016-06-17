package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.eval.ServerEvaluationCall;

import model.user.User;

/**
 * Servlet implementation class RemoveAmandman
 */
public class RemoveAmandman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveAmandman() {
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
		DatabaseClient client = (DatabaseClient)request.getSession().getAttribute("client");
		//String fileName = request.getParameter("fileName");
		String fileUri = request.getParameter("fileUri");
		
		ServerEvaluationCall call = client.newServerEval()
				.xquery("xdmp:document-delete(\""+fileUri+"\")");
				call.eval();	
				ReloadContext rC = new ReloadContext();
			    rC.reload(getServletContext(), (DatabaseClient)request.getSession().getAttribute("client"));
		
		/*if(user.getRole().equals("Odbornik"))
        	getServletContext().getRequestDispatcher("/ActsInProgressAlderman.jsp").forward(request, response);
        else*/ if(user.getRole().equals("Predsednik"))
        	getServletContext().getRequestDispatcher("/ResultsPresident.jsp").forward(request, response);	
	
	}

}
