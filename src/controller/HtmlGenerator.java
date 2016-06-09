package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.SAXException;

import xmlTransformations.XMLReader;
import xmlTransformations.XSLFOTransformer;
import xquery.Util;

/**
 * Servlet implementation class HtmlGenerator
 */
public class HtmlGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtmlGenerator() {
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
		try {
			XMLReader xmlReader = new XMLReader();
			String fileRoot = request.getParameter("fileRoot"); 
			Document xmlDocument =  xmlReader.run(Util.loadProperties(), fileRoot);
			
			xmlDocument.setXmlStandalone(true);
			ProcessingInstruction pi = xmlDocument.createProcessingInstruction("xml-stylesheet", "type=\"text/css\" href=\"css/aktStyle.css\"");  
			xmlDocument.insertBefore(pi, xmlDocument.getFirstChild());
			
			OutputStream responseOutputStream = response.getOutputStream();


ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
Source xmlSource = new DOMSource(xmlDocument);
Result outputTarget = new StreamResult(outputStream);
TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
InputStream is = new ByteArrayInputStream(outputStream.toByteArray());

			int bytes;
			while ((bytes = is.read()) != -1) {
				responseOutputStream.write(bytes);
			}
			is.close();
			responseOutputStream.close(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}

}
