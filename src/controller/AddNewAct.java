package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

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
        try {
          validator.validate(tempXmlFile);
          System.out.println(tempXmlFile.getSystemId() + " is valid");
          String message = "Dokument je validan!";
          request.setAttribute("message", message);
        } catch (SAXException e) {
          System.out.println(tempXmlFile.getSystemId() + " is NOT valid");
          System.out.println("Reason: " + e.getLocalizedMessage());
          String message = "Dokument nije validan! Razlog : " + e.getLocalizedMessage();
          request.setAttribute("message", message);
        }
	    
        getServletContext().getRequestDispatcher("/NewActAlderman.jsp").forward(request, response);
	}
	
	

}
