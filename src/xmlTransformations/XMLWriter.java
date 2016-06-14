package xmlTransformations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;

import xquery.Util;
import xquery.Util.ConnectionProperties;


public class XMLWriter {

	public static void run(DatabaseClient client, String docId) throws FileNotFoundException {
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		
		//InputStreamHandle handle = new InputStreamHandle(new FileInputStream("data/xsl-fo/zop.xml"));
		
		//DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		//metadata.getCollections().add("akti/usvojeni");
		
		//xmlManager.write(docId, metadata, handle);
		xmlManager.delete(docId);
	}

	public static void main(String[] args) throws IOException {
		DatabaseClient client ;
		ConnectionProperties props = Util.loadProperties();
		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
		}
		run(client, "/zor.xml");
	}

}
