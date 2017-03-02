package org.se.lab.codegenerator;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceVisitorImplTest extends AbstractVisitorTest {
	
	@Test
	public void testGenCode() throws IOException {
		Visitor visitor = new GenInterfaceVisitorImpl();
		visitor.visit(getPkg());

		String expected = readFile("Stack.java"); 
		String actual = visitor.genCode();
				
		Assert.assertEquals(expected, actual);
	}
}
