package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.marklogic.client.DatabaseClient;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import xmlTransformations.XMLReader;
import xmlTransformations.XSLFOTransformer;
import xquery.Util;

/**
 * Servlet implementation class PdfGenerator
 */
public class PdfGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String fileName = request.getParameter("fileName"); 
			String fileUri = request.getParameter("fileUri");
			
			XMLReader reader = new XMLReader();
			DatabaseClient client = (DatabaseClient) request.getSession().getAttribute("client");
			Document xmlDocument = reader.run(client, fileUri);
			
			try {
				xmlDocument.insertBefore(DocumentBuilderFactory
					    .newInstance()
					    .newDocumentBuilder()
					    .parse(new ByteArrayInputStream("<?xml-stylesheet type=\"text/xsl\" href=\"akt_fo.xsl\"?>".getBytes()))
					    .getDocumentElement(), xmlDocument.getFirstChild());
			} catch (DOMException | SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			XSLFOTransformer xslFoTransformer = new XSLFOTransformer();
			File pdfFile = xslFoTransformer.transformToPdf(xmlDocument);
			
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			OutputStream responseOutputStream = response.getOutputStream();
			
			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
				responseOutputStream.write(bytes);
			}
			fileInputStream.close();
			responseOutputStream.close(); 
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	 
}
