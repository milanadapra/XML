package xmlTransformations;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.w3c.dom.Document;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.DocumentMetadataHandle;


public class XMLReader {
		
	public Document run(DatabaseClient client, String docId) throws FileNotFoundException {
		
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		DOMHandle content = new DOMHandle();
		
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		
		xmlManager.read(docId, metadata, content);
		
		Document doc = content.get();

		return doc;
	}


	public static void main(String[] args) throws IOException {
		//XMLReader r = new XMLReader();
		//r.run(Util.loadProperties(), "/example/akti/usvojeni/test.xml").toString();
	}
}
