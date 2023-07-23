package org.se.lab.metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InterfaceMetamodelTest
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
	public void testPackage()
	{
		Assert.assertEquals("org.se.lab", pkg.getName());
		Assert.assertEquals(1, pkg.getInterfaces().size());
	}
	
	@Test
	public void testInterface()
	{
		MInterface iface = pkg.getInterfaces().get(0);
		
		Assert.assertEquals("Stack", iface.getName());
		Assert.assertEquals(true, iface.isPublic());
		Assert.assertEquals(5, iface.getOperations().size());
	}
	
	@Test 
	public void testPush()
	{
		// void push(int value);
		MOperation op = pkg.getInterfaces().get(0).getOperations().get(0);
		Assert.assertEquals("push", op.getName());
		Assert.assertEquals("void", op.getType().getName());
		
		MParameter p = op.getParameters().get(0);
		Assert.assertEquals("value", p.getName());
		Assert.assertEquals("int", p.getType().getName());
	}
	
	@Test 
	public void testPop()
	{
		// int pop();
		MOperation op = pkg.getInterfaces().get(0).getOperations().get(1);
		Assert.assertEquals("pop", op.getName());
		Assert.assertEquals("int", op.getType().getName());
	}

	@Test 
	public void testTop()
	{
		// int top();
		MOperation op = pkg.getInterfaces().get(0).getOperations().get(2);
		Assert.assertEquals("top", op.getName());
		Assert.assertEquals("int", op.getType().getName());
	}
	
	@Test 
	public void testIsEmpty()
	{
		// boolean isEmpty();
		MOperation op = pkg.getInterfaces().get(0).getOperations().get(3);
		Assert.assertEquals("isEmpty", op.getName());
		Assert.assertEquals("boolean", op.getType().getName());
	}
	
	@Test 
	public void testIsFull()
	{
		// boolean isFull();
		MOperation op = pkg.getInterfaces().get(0).getOperations().get(4);
		Assert.assertEquals("isFull", op.getName());
		Assert.assertEquals("boolean", op.getType().getName());
	}
}
