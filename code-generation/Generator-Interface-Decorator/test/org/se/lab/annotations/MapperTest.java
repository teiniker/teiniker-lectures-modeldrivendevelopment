package org.se.lab.annotations;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public class MapperTest {
	
	private MPackage expected;
	
	@Before
	public void setup() {
		expected = new MPackage("org.se.lab.annotations");
		
		MInterface iface = new MInterface("Stack");
		iface.setPublic(true);		
		expected.getInterfaces().add(iface);
		
		MOperation push = new MOperation("push", new MType("void"));
		push.getParameters().add(new MParameter("arg0", new MType("int")));
		iface.getOperations().add(push);
		iface.getOperations().add(new MOperation("pop", new MType("int")));
		iface.getOperations().add(new MOperation("top", new MType("int")));
		iface.getOperations().add(new MOperation("isEmpty", new MType("boolean")));
		iface.getOperations().add(new MOperation("isFull", new MType("boolean")));
	}
	
	@Test
	public void testGenModel() throws IOException {
		MPackage actual = Mapper.genModel(Stack.class);
		
		Assert.assertEquals(this.expected, actual);
	}
		

}
