package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.xml.sax.SAXException;

import com.marklogic.client.DatabaseClient;

import xmlTransformations.XMLWriter;


/**
 * Servlet implementation class UploadAct
 */
public class UploadAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAct() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Request does not contain upload data");
            writer.flush();
            return;
        }
         
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
         
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_REQUEST_SIZE);
         
        // constructs the directory path to store upload file
        String uploadPath = getServletContext().getRealPath("")
            + File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
         
        try {
            // parses the request's content to extract file data
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();
             
            // iterates over form's fields
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                // processes only fields that are not form fields
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    // saves the file on disk
                    item.write(storeFile);
                    
                    File schemaFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().concat("/../../../xml/akt.xsd"));
                    Source xmlFile = new StreamSource(storeFile);
                    SchemaFactory schemaFactory = SchemaFactory
                        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                    Schema schema = schemaFactory.newSchema(schemaFile);
                    Validator validator = schema.newValidator();
                    try {
                      validator.validate(xmlFile);
                      System.out.println(xmlFile.getSystemId() + " is valid");
                      XMLWriter writer = new XMLWriter();
                      writer.run((DatabaseClient)request.getSession().getAttribute("client"), "/"+fileName, xmlFile);
                      request.setAttribute("valid", fileName + " is valid");
                      request.setAttribute("notValid","");
                      request.setAttribute("reason", "");
                    } catch (SAXException e) {
                      System.out.println(xmlFile.getSystemId() + " is NOT valid");
                      System.out.println("Reason: " + e.getLocalizedMessage());
                      request.setAttribute("notValid",fileName + " is NOT valid");
                      request.setAttribute("reason", "Reason: " + e.getLocalizedMessage());
                      request.setAttribute("valid", "");
                    }
                }
            }
            System.out.println("Upload has been done successfully!");
        } catch (Exception ex) {
            System.out.println("There was an error: " + ex.getMessage());
        }
        getServletContext().getRequestDispatcher("/NewActAlderman.jsp").forward(request, response);
    
	}

}
