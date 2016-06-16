package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.marklogic.client.DatabaseClient;

import xmlTransformations.XMLWriter;

/**
 * Servlet implementation class AddNewAct
 */
public class AddNewAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String UPLOAD_DIRECTORY = "upload";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewAct() {
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
		
		String fileName = request.getParameter("filename");
		String xmlText = request.getParameter("tekst");
		String user = request.getParameter("user");
		
		// constructs the directory path to store upload file
        String uploadPath = getServletContext().getRealPath("")
            + File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        File xmlFile = new File(uploadPath + File.separator + fileName + ".xml");
		java.io.FileWriter fw = new java.io.FileWriter(xmlFile);
	    fw.write(xmlText);
	    fw.close();
	    
	    File schemaFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().concat("/../../../xml/akt.xsd"));
        Source tempXmlFile = new StreamSource(xmlFile);
        SchemaFactory schemaFactory = SchemaFactory
            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
		try {
			schema = schemaFactory.newSchema(schemaFile);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Validator validator = schema.newValidator();
        XMLWriter writer = new XMLWriter();
        
        try {
          validator.validate(tempXmlFile);
          
          try {
			writer.run((DatabaseClient)request.getSession().getAttribute("client"), "/"+fileName + ".xml", tempXmlFile,"akti/uproceduri");
		} catch (TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println(tempXmlFile.getSystemId() + " is valid");
          request.setAttribute("valid", fileName + " is valid");
          request.setAttribute("notValid","");
          request.setAttribute("reason", "");
        } catch (SAXException e) {
          System.out.println(tempXmlFile.getSystemId() + " is NOT valid");
          System.out.println("Reason: " + e.getLocalizedMessage());
          request.setAttribute("notValid",fileName + " is NOT valid");
          request.setAttribute("reason", "Reason: " + e.getLocalizedMessage());
          request.setAttribute("valid", "");
        }
	    
        if(user.equals("Odbornik")) {
        	getServletContext().getRequestDispatcher("/NewActAlderman.jsp").forward(request, response);
        }
        else
        	getServletContext().getRequestDispatcher("/NewActPresident.jsp").forward(request, response);

	}
	
	

}
