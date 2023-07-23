package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WebPageGeneratorTest
{
	protected MWebPage page;
		
	@Before
	public void setup()
	{
		page = new MWebPage();
		
		MHead head = new MHead("Software Modeling");
		page.setHead(head);
		
		MBody body = new MBody();
		MHeadline h1 = new MHeadline("Hello world!", 1);
		MParagraph p = new MParagraph("This is a simple web page..");
		body.getElements().add(h1);
		body.getElements().add(p);
		
		page.setBody(body);
	}
	
	@Test
	public void testGenerate()
	{
		WebPageGenerator generator = new WebPageGenerator();
		String html = generator.generate(page);
		String expected = readFile("simple-page.html");
		Assert.assertEquals(expected, html);
	}
	
	
	protected String readFile(String filename)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"src/test/resources", filename))))
		{
			StringBuilder xml = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null)
			{
				xml.append(line).append('\n');
			}
			return xml.toString();
		}
		catch(IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
