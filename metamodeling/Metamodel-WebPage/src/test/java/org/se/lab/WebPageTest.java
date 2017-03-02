package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WebPageTest
{
	private MWebPage page;
	
	@Before
	public void setup()
	{
		// Model
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
	public void testModel()
	{
		Assert.assertEquals("Software Modeling", page.getHead().getTitle());
	}
}
