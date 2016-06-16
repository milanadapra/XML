package controller;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;

import com.marklogic.client.DatabaseClient;

import xmlTransformations.XMLCollectionReader;

public class ReloadContext {

	public void reload(ServletContext context, DatabaseClient client) throws FileNotFoundException{
		XMLCollectionReader xmlCollection = new XMLCollectionReader();
		xmlCollection.readDocuments(client);
		
		context.setAttribute("usvojeniAkti", xmlCollection.getUsvojeniAkti());
		context.setAttribute("aktiUproceduri", xmlCollection.getAktiUproceduri());
		context.setAttribute("amandmani", xmlCollection.getAmandmaniUproceduri());
		context.setAttribute("usvojeniAmandmani", xmlCollection.getUsvojeniAmandmani());
	}
}
