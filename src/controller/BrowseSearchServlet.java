package controller;

import java.io.IOException;import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.MatchSnippet;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;

/**
 * Servlet implementation class BrowseSearchServlet
 */
public class BrowseSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String COLLECTION = "akti/usvojeni";

       
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
		
		DatabaseClient client = (DatabaseClient)request.getSession().getAttribute("client");
		QueryManager queryManager = client.newQueryManager();
		
		// Query definition is used to specify Google-style query string
		StringQueryDefinition queryDefinition = queryManager.newStringDefinition();
			
		String criteria = sadrzaj;
		queryDefinition.setCriteria(criteria);
		
		// Search within a specific collection
		queryDefinition.setCollections(COLLECTION);
		
		// Perform search
		SearchHandle results = queryManager.search(queryDefinition, new SearchHandle());
		MatchDocumentSummary matches[] = results.getMatchResults();
		System.out.println("[INFO] Showing the results for: " + criteria + "\n");

		MatchDocumentSummary result;
		MatchLocation locations[];
		String text;
		
		response.getWriter().print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		response.getWriter().print("<?xml-stylesheet type=\"text/css\" href=\"css/searchStyle.css\"?>");
		for (int i = 0; i < matches.length; i++) {
			result = matches[i];
			response.getWriter().print("<Rezultat>");
			response.getWriter().print((i+1) + ". Detalji pretrage: ");
			response.getWriter().print("\n - URI: " + result.getUri());
			
			locations = result.getMatchLocations();
			response.getWriter().print("\n     ( Pronadjenih dokumenata: " + locations.length + ") \n");

			for (MatchLocation location : locations) {
				response.getWriter().print("<Lokacija>");
				response.getWriter().print("<Sadrzaj>");
				for (MatchSnippet snippet : location.getSnippets()) {
					text = snippet.getText().trim();
					if (!text.equals("")) {
						response.getWriter().print(snippet.isHighlighted()? text.toUpperCase() : text);
						response.getWriter().print(" ");
					}
				}
				response.getWriter().print("</Sadrzaj>");
				response.getWriter().print("<Putanja>");
				response.getWriter().print("\n " + location.getPath());
				response.getWriter().print("</Putanja>");
				response.getWriter().print("</Lokacija>");
			}
			
			response.getWriter().print("</Rezultat>");
		}
		
	}

}
