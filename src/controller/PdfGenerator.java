package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;
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
			XMLReader xmlReader = new XMLReader();
			String fileRoot = request.getParameter("fileName"); 
			Document xmlDocument =  xmlReader.run(Util.loadProperties(), fileRoot);
			
			XSLFOTransformer xslFoTransformer = new XSLFOTransformer();
			File pdfFile = xslFoTransformer.transformToPdf(xmlDocument);
			
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileRoot);
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
