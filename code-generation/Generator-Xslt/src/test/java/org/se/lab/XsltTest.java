package org.se.lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;


public class XsltTest 
{
	private static final String SRC_DIR = "src/test/resources";
	private static final String DEST_DIR = "target";

	
	@Test
	public void testCpdReport() throws TransformerException, IOException
	{
		process("xml/cpd-report.xml", 
				"xml/cpdhtml.xslt", 
				"cpd-retort.html");		
	}
	
	@Test
	public void testJavaNcssReport() throws TransformerException, IOException
	{
		process("xml/javancss-report.xml", 
				"xml/javancss2html.xsl", 
				"javancss-retort.html");		
	}
	
	@Test
	public void testJavaNcssClasses() throws TransformerException, IOException
	{
		process("xml/javancss-report.xml", 
				"xml/javancss-classes.xslt", 
				"javancss-ccn.xml");		
	}
	
	
	protected void process(final String xml, final String xslt, final String out) 
		throws IOException, TransformerException
	{
		Source xmlSource = new StreamSource(new File(SRC_DIR, xml));
		Source xsltSource = new StreamSource(new File(SRC_DIR, xslt));
		
		Result result = new StreamResult(new FileWriter(new File(DEST_DIR, out)));
		
		// create an instance of TransformerFactory
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		trans.transform(xmlSource, result);		
	}
}
