package xmlTransformations;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.eval.EvalResult;
import com.marklogic.client.eval.ServerEvaluationCall;
import com.marklogic.client.io.SearchHandle;
import com.marklogic.client.query.MatchDocumentSummary;
import com.marklogic.client.query.MatchLocation;
import com.marklogic.client.query.MatchSnippet;
import com.marklogic.client.query.QueryManager;
import com.marklogic.client.query.StringQueryDefinition;

import xquery.Util;
import xquery.Util.ConnectionProperties;

public class XMLSearchResult {

private static DatabaseClient client;
	
	private static final String COLLECTION = "/example/akti/usvojeni";
	
	public static void run(ConnectionProperties props) throws FileNotFoundException {
		
		System.out.println("[INFO] " + XMLSearchResult.class.getSimpleName());
		
		if (props.database.equals("")) {
			System.out.println("[INFO] Using default database.");
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
		} else {
			System.out.println("[INFO] Using \"" + props.database + "\" database.");
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
		}
		
		QueryManager queryManager = client.newQueryManager();
		
		StringQueryDefinition queryDefinition = queryManager.newStringDefinition();
		
		String criteria = "Zakon";//angularjs OR test AND \"Kurt Cagle\"
		queryDefinition.setCriteria(criteria);
		
		queryDefinition.setCollections(COLLECTION);
		
		SearchHandle results = queryManager.search(queryDefinition, new SearchHandle());
		
		
		
		MatchDocumentSummary matches[] = results.getMatchResults();
		System.out.println("[INFO] Showing the results for: " + criteria + "\n");

		 ServerEvaluationCall call = client.newServerEval()
			        .xquery("cts:uris()");
			    for ( EvalResult result : call.eval() ) {
			        String uri = result.getString();
			        System.out.println(uri);
			    }
		
		MatchDocumentSummary result;
		MatchLocation locations[];
		String text;
		
		for (int i = 0; i < matches.length; i++) {
			result = matches[i];
			
			System.out.println((i+1) + ". RESULT DETAILS: ");
			System.out.println("Result URI: " + result.getUri());
			
			locations = result.getMatchLocations();
			System.out.println("Document locations matched: " + locations.length + "\n");

			for (MatchLocation location : locations) {
				
				System.out.print(" - ");
				for (MatchSnippet snippet : location.getSnippets()) {
					text = snippet.getText().trim();
					if (!text.equals("")) {
						System.out.print(snippet.isHighlighted()? text.toUpperCase() : text);
						System.out.print(" ");
					}
				}
				System.out.println("\n - Match location XPath: " + location.getPath());
				System.out.println();
			}
			
			System.out.println();
		}
		
		
		client.release();
		
		System.out.println("[INFO] End.");
	}
	
	
	public static void main(String[] args) throws IOException {
		run(Util.loadProperties());
		
	}

}


