package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.*;

public class IdentifierValidatorTest
{
	private MPackage pkg;

	@Before
	public void setup()
	{
		pkg = new MPackage("org.se.lab");
		
		MInterface iface = new MInterface("Stack");
		iface.setPublic(true);		
		pkg.getInterfaces().add(iface);
		
		MOperation push = new MOperation("push", new MType("void"));
		push.getParameters().add(new MParameter("value", new MType("int")));
		iface.getOperations().add(push);
		iface.getOperations().add(new MOperation("pop", new MType("int")));
		iface.getOperations().add(new MOperation("top", new MType("int")));
		iface.getOperations().add(new MOperation("isEmpty", new MType("boolean")));
		iface.getOperations().add(new MOperation("isFull", new MType("boolean")));
	}

	
	@Test
	public void testInvalidTypeIdentifier()
	{
		pkg.getInterfaces().get(0).getOperations().get(0).getParameters().get(0).getType().setName(null);
		
		try
		{
			pkg.validate();
			Assert.fail();
		}
		catch(IllegalStateException e)
		{
			Assert.assertEquals("Invalid identifier null at org.se.lab.metamodel.MType", e.getMessage());
		}
	}
	
	// ...
}
