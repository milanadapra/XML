package xmlTransformations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.InputStreamHandle;

import xquery.Util;
import xquery.Util.ConnectionProperties;

/**
 * 
 * [PRIMER 1]
 * 
 * Primer demonstrira pisanje XML dokumenta sa unapred zadatim URI-jem u
 * MarkLogic XMLDB upotrebom Java API-ja (XMLDocumentManager klase).
 * 
 * Nakon izvršavanja primera pristupiti REST API-ju otvaranjem sledećeg URL-a
 * direktno iz browser-a:
 * 
 * http://{host}:8000/v1/documents?database={database}&uri=/example/test/books.xml
 * 
 * ili kroz MarkLogic-ov Query Console na adresi:
 * 
 * http://{host}:8000/qconsole/
 * 
 * Za detaljan opis parametara MarkLogic-ovog klijentskog REST API-ja posetiti:
 * 
 * https://docs.marklogic.com/REST/client
 * 
 */

public class XMLWriter {

	private static DatabaseClient client;
	
	public static void run(ConnectionProperties props) throws FileNotFoundException {
		
		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
		}
		
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		
		String docId = "/example/akti/usvojeni/aktStyle.css";
		
		InputStreamHandle handle = new InputStreamHandle(new FileInputStream("data/xsl-fo/aktStyle.css"));
		
		xmlManager.write(docId, handle);
		
		System.out.println("[INFO] Verify the content at: http://" + props.host + ":8000/v1/documents?database=" + props.database + "&uri=" + docId);
		
		client.release();
		
	}

	public static void main(String[] args) throws IOException {
		run(Util.loadProperties());
	}

}
