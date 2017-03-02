package org.se.lab.codegenerator;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GenAbstractDecoratorVisitorImplTest extends AbstractVisitorTest {
	
	@Test
	public void testGenCode() throws IOException {
		Visitor visitor = new GenAbstractDecoratorVisitorImpl();
		visitor.visit(getPkg());

		String expected = readFile("AbstractStackDecorator.java"); 
		String actual = visitor.genCode();
		
		Assert.assertEquals(expected, actual);
	}
}
