package xmlTransformations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.eval.EvalResult;
import com.marklogic.client.eval.ServerEvaluationCall;


public class XMLCollectionReader {
	private HashMap<String, String> aktiUproceduri = new HashMap<String, String>();
	private HashMap<String, String> usvojeniAkti = new HashMap<String, String>();
	private HashMap<String, String> amandmaniUproceduri = new HashMap<String, String>();
	private HashMap<String, String> usvojeniAmandmani = new HashMap<String, String>();
	private HashMap<String, String> odbijeniAkti = new HashMap<String, String>();
	
	public void readDocuments(DatabaseClient client) throws FileNotFoundException {
		
		XMLReader reader = new XMLReader();
		
		ServerEvaluationCall urisCall = client.newServerEval()
			        .xquery("cts:uris()");//uris
		for ( EvalResult result : urisCall.eval() ) 
		{
	        String uri = result.getString();
	        Document doc = (reader.run(client, uri));
	        ServerEvaluationCall collectionCall = client.newServerEval()
			        .xquery("xdmp:document-get-collections(\""+uri+"\")");
	        for ( EvalResult collection : collectionCall.eval() ) 
			{
	        	String colect = collection.getString();
	        	switch(colect){
	        		case "akti/usvojeni": {usvojeniAkti.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri); break;}
	        		case "akti/odbijeni": {odbijeniAkti.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri); break;}
	        		case "akti/uproceduri": {aktiUproceduri.put(((Element)doc.getFirstChild()).getAttribute("Naziv").toString(), uri); break;}
	        		case "amandmani/usvojeni": break;
	        		case "amandmani/uproceduri": {amandmaniUproceduri.put((amandmaniUproceduri.size()+1) + ") Amandman za akt: "+ ((Element)doc.getFirstChild()).getAttribute("Akt").toString(), uri); break;}
	        		default: break;
	        	}
			}
	    }
	}
	
	
	public HashMap<String, String> getAktiUproceduri() {
		return aktiUproceduri;
	}


	public HashMap<String, String> getUsvojeniAkti() {
		return usvojeniAkti;
	}


	public HashMap<String, String> getAmandmaniUproceduri() {
		return amandmaniUproceduri;
	}


	public HashMap<String, String> getUsvojeniAmandmani() {
		return usvojeniAmandmani;
	}


	public HashMap<String, String> getOdbijeniAkti() {
		return odbijeniAkti;
	}


	public void main(String[] args) throws IOException {
		//run(Util.loadProperties());
		
	}
}