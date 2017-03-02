package org.se.lab.codegenerator;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GenMonitorDecoratorVisitorImplTest extends AbstractVisitorTest {
	
	@Test
	public void testGenCode() throws IOException {
		Visitor visitor = new GenMonitorDecoratorVisitorImpl();
		visitor.visit(getPkg());

		String expected = readFile("StackMonitorDecorator.java"); 
		String actual = visitor.genCode();
		
		Assert.assertEquals(expected, actual);
	}
}
