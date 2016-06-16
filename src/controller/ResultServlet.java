package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.DocumentPatchBuilder;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.document.DocumentPatchBuilder.Position;
import com.marklogic.client.eval.ServerEvaluationCall;
import com.marklogic.client.io.marker.DocumentPatchHandle;
import com.marklogic.client.util.EditableNamespaceContext;

import xmlTransformations.XMLReader;

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
		XMLReader reader = new XMLReader();
		Document doc = (reader.run(client, file));
		
        Node clan = doc.getElementsByTagName("Clan").item(0);

		
		XMLDocumentManager xmlManager = client.newXMLDocumentManager();
		EditableNamespaceContext namespaces = new EditableNamespaceContext();
		namespaces.put("b", "http://www.ftn.uns.ac.rs/XML");
		
		DocumentPatchBuilder patchBuilder = xmlManager.newPatchBuilder();
		patchBuilder.setNamespaces(namespaces);
			
		
		if(za > protiv) {
			ServerEvaluationCall call = client.newServerEval()
					.xquery("xdmp:document-set-collections(\""+ file +"\",\"amandmani/usvojeni\")");
			call.eval();
			String namena = doc.getFirstChild().getAttributes().getNamedItem("VrstaAmandmana").getNodeValue();
			
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				Source xmlSource = new DOMSource(clan);
				Result outputTarget = new StreamResult(outputStream);
				try {
					String contextXPath1 = doc.getFirstChild().getAttributes().getNamedItem("BrojClana").getNodeValue();
					if(namena.equals("delete")){
						patchBuilder.delete(contextXPath1);
						DocumentPatchHandle patchHandle = patchBuilder.build();
						xmlManager.patch(doc.getFirstChild().getAttributes().getNamedItem("Akt").getNodeValue(), patchHandle);
					}
					else if(namena.equals("update")){
						TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
						String textValue = new String(outputStream.toByteArray());
						textValue = textValue.substring(38);
						
						textValue = textValue.replaceAll("<", "<b:");
						textValue = textValue.replaceAll("<b:/", "</b:");
						textValue = textValue.replaceAll("xmlns=\"http://www.ftn.uns.ac.rs/XML\"", "");
						
						patchBuilder.replaceFragment(contextXPath1, textValue);
						DocumentPatchHandle patchHandle = patchBuilder.build();
						xmlManager.patch(doc.getFirstChild().getAttributes().getNamedItem("Akt").getNodeValue(), patchHandle);
					}
					else if(namena.equals("insert")){
						TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
						String textValue = new String(outputStream.toByteArray());
						textValue = textValue.substring(38);
						
						textValue = textValue.replaceAll("<", "<b:");
						textValue = textValue.replaceAll("<b:/", "</b:");
						textValue = textValue.replaceAll("xmlns=\"http://www.ftn.uns.ac.rs/XML\"", "");
						
						patchBuilder.insertFragment(contextXPath1, Position.BEFORE, textValue);
						DocumentPatchHandle patchHandle = patchBuilder.build();
						xmlManager.patch(doc.getFirstChild().getAttributes().getNamedItem("Akt").getNodeValue(), patchHandle);
						
					}
					
				} catch (TransformerException | TransformerFactoryConfigurationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		else {
			ServerEvaluationCall call = client.newServerEval()
			.xquery("xdmp:document-delete(\""+file+"\")");
			call.eval();	
		}
		ReloadContext rC = new ReloadContext();
		rC.reload(getServletContext(), (DatabaseClient)request.getSession().getAttribute("client"));
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
