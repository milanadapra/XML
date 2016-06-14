package xmlTransformations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 * 
 * Primer demonstrira koriscenje programskog API-a za 
 * renderovanje PDF-a na osnovu XSL-FO transformacije.
 *
 */
public class XSLFOTransformer {
	
	private FopFactory fopFactory;
	
	private TransformerFactory transformerFactory;
	
	public XSLFOTransformer() throws SAXException, IOException {
		
		File fopFile = new File(getClass().getProtectionDomain().getCodeSource().
				getLocation().getPath().concat("/../../../xml/fop.xconf"));
		
		fopFactory = FopFactory.newInstance(fopFile);
		transformerFactory= TransformerFactory.newInstance(
		        "net.sf.saxon.TransformerFactoryImpl", null);
	}

	public File transformToPdf(Document fileContent) throws Exception {
		
		File xsltFile = new File(getClass().getProtectionDomain().getCodeSource().
				getLocation().getPath().concat("/../../../xml/akt_fo.xsl"));
		
		StreamSource transformSource = new StreamSource(xsltFile);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(fileContent), new StreamResult(writer));
		String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
		
		
		StreamSource source = new StreamSource(new ByteArrayInputStream(output.getBytes("UTF8")),"UTF-8");
		 
		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

		Result res = new SAXResult(fop.getDefaultHandler());

		xslFoTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		xslFoTransformer.transform(source, res);

		File pdfFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath().concat("/../../../lastSeen.pdf"));
		System.out.println(pdfFile.getAbsolutePath());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
		out.write(outStream.toByteArray());

		out.close();
		return pdfFile;

	}

	/*public static void main(String[] args) throws Exception {

		new XSLFOTransformer().transformToPdf((Document)new File("data/xsl-fo/test.xml"));
	}*/
}
