package org.se.lab.parser;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public class ANTLRParserTest {

	private MPackage expected;
	
	@Before
	public void setup() {
		expected = new MPackage("org.se.lab.parser");
		
		MInterface iface = new MInterface("Stack");
		iface.setPublic(true);		
		expected.getInterfaces().add(iface);
		
		MOperation push = new MOperation("push", new MType("void"));
		push.getParameters().add(new MParameter("value", new MType("int")));
		iface.getOperations().add(push);
		iface.getOperations().add(new MOperation("pop", new MType("int")));
		iface.getOperations().add(new MOperation("top", new MType("int")));
		iface.getOperations().add(new MOperation("isEmpty", new MType("boolean")));
		iface.getOperations().add(new MOperation("isFull", new MType("boolean")));
	}
	
	@Test
	public void testParse() throws IOException, RecognitionException {
		MPackage actual = ANTLRParser.parse("test/org/se/lab/parser/Stack.java");
		
		
		
		Assert.assertEquals(expected, actual);
	}
}
