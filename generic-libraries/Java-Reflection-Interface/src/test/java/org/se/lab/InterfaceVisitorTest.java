package org.se.lab;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InterfaceVisitorTest
{
	private InterfaceVisitor visitor;
	
	@Before
	public void setup()
	{
		visitor = new InterfaceVisitorImpl();
	}
	
	@Test
	public void testUserEntity()
	{
		visitor.visit(UserService.class);
		
		Map<String, Boolean> operationMap = visitor.getOperationMap();
		
		Assert.assertEquals(4, operationMap.size());
		
		Assert.assertEquals(true, operationMap.get("addUser"));
		Assert.assertEquals(true, operationMap.get("removeUser"));
		Assert.assertEquals(false, operationMap.get("findUserByName"));
		Assert.assertEquals(false, operationMap.get("isKnownUser"));
	}
}
