package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntityVisitorTest
{
	private EntityVisitor visitor;
	
	@Before
	public void setup()
	{
		visitor = new EntityVisitorImpl();
	}
	
	@Test
	public void testUserEntity()
	{
		String s = visitor.visitEntity(User.class);
		
		Assert.assertEquals("User{ id:int[id] username:String password:String }", s);
	}
}
