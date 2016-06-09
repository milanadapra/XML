package xmlTransformations;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DOMHandle;
import com.marklogic.client.io.DocumentMetadataHandle;

import xquery.Util;
import xquery.Util.ConnectionProperties;

public class XMLReader {
		
	private  DatabaseClient client;
	private  TransformerFactory transformerFactory = TransformerFactory.newInstance();
	
	public Document run(ConnectionProperties props, String docId) throws FileNotFoundException {
		
		if (props.database.equals("")) {
			client = DatabaseClientFactory.newClient(props.host, props.port, props.user, props.password, props.authType);
		} else {
			System.out.println(props.host+ props.port+props.database+props.user+props.password+ props.authType);
			client = DatabaseClientFactory.newClient(props.host, props.port, props.database, props.user, props.password, props.authType);
		}
		
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();

		DOMHandle content = new DOMHandle();
		
		DocumentMetadataHandle metadata = new DocumentMetadataHandle();
		
		//String docId = "/example/books.xml";
		
		System.out.println("[INFO] Retrieving \"" + docId + "\" from "
				+ (props.database.equals("") ? "default" : props.database)
				+ " database.");
		
		xmlManager.read(docId, metadata, content);
		

		Document doc = content.get();

	
		client.release();
		//return transform(doc, System.out);
		return doc;
	}

	private OutputStream transform(Node node, OutputStream out) {
		StreamResult result = new StreamResult(out);
		try {

			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(node);

			//StreamResult result = new StreamResult(out);
			
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return result.getOutputStream();
	}

	public static void main(String[] args) throws IOException {
		XMLReader r = new XMLReader();
		r.run(Util.loadProperties(), "/example/akti/usvojeni/test.xml").toString();
	}
}
