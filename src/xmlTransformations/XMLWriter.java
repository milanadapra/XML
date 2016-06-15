package xmlTransformations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.InputStreamHandle;

import xquery.Util;
import xquery.Util.ConnectionProperties;


public class XMLWriter {

	public void run(DatabaseClient client, String docId, Source source) throws FileNotFoundException, TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Result outputTarget = new StreamResult(outputStream);
		TransformerFactory.newInstance().newTransformer().transform(source, outputTarget);
		InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
		
		InputStreamHandle handle = new InputStreamHandle(is);
		//		InputStreamHandle handle = new InputStreamHandle(new FileInputStream("data/xsl-fo/zop.xml"));
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		metadata.getCollections().add("akti/usvojeni");
		
		xmlManager.write(docId, metadata, handle);
		//xmlManager.delete(docId);
	}

	public static void main(String[] args) throws IOException {
		DatabaseClient client ;
		ConnectionProperties props = Util.loadProperties();
		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
		} else {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
		}
		//XMLWriter wr = new XMLWriter();
		//wr.run(client, "/zor.xml");
	}

}
