package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.eval.ServerEvaluationCall;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer za = Integer.parseInt(request.getParameter("za"));
		Integer protiv = Integer.parseInt(request.getParameter("protiv"));
		String file = request.getParameter("fileUri");
		
		DatabaseClient client = (DatabaseClient)request.getSession().getAttribute("client");
		
		if(za > protiv) {
			ServerEvaluationCall call = client.newServerEval()
					.xquery("xdmp:document-set-collections(\""+ file +"\",\"amandmani/usvojeni\")");
			call.eval();
		}
		else {
			ServerEvaluationCall call = client.newServerEval()
			.xquery("xdmp:document-delete("+file+")");
			call.eval();	
		}
		response.sendRedirect("ResultsPresident.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer za = Integer.parseInt(request.getParameter("za"));
		Integer protiv = Integer.parseInt(request.getParameter("protiv"));
		String file = request.getParameter("fileUri");
		
		DatabaseClient client = (DatabaseClient)request.getSession().getAttribute("client");
		
		if(za > protiv) {
			ServerEvaluationCall call = client.newServerEval()
					.xquery("xdmp:document-set-collections(\""+ file +"\",\"akti/usvojeni\")");
			call.eval();
		}
		else {
			ServerEvaluationCall call = client.newServerEval()
					.xquery("xdmp:document-delete("+file+")");
			call.eval();
		}
		response.sendRedirect("ResultsPresident.jsp");
	}

}
