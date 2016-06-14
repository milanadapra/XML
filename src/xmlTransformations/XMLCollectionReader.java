package xmlTransformations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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

public class XMLCollectionReader {
	private HashMap<String, String> aktiUproceduri = new HashMap<String, String>();
	private HashMap<String, String> usvojeniAkti = new HashMap<String, String>();
	private HashMap<String, String> amandmani = new HashMap<String, String>();
	
	public void readDocuments(DatabaseClient client) throws FileNotFoundException {
		
		XMLReader reader = new XMLReader();
		
		ServerEvaluationCall call = client.newServerEval()
			        .xquery("cts:uris()");
		for ( EvalResult result : call.eval() ) 
		{
	        String uri = result.getString();
	        Document doc = (reader.run(client, uri));
	        if(uri.contains("usvojeni"))
	        	usvojeniAkti.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri);
	        else if(uri.contains("uproceduri"))
	        	aktiUproceduri.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri);
	        else if(uri.contains("amandmani"))
	        	amandmani.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri);
	        
	    }
	}
	
	public HashMap<String, String> getAktiUproceduri() {
		return aktiUproceduri;
	}

	public HashMap<String, String> getUsvojeniAkti() {
		return usvojeniAkti;
	}

	public HashMap<String, String> getAmandmani() {
		return amandmani;
	}

	public void main(String[] args) throws IOException {
		//run(Util.loadProperties());
		
	}
}