package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.User;


public class UserTest
{

	@Test
	public void testToString()
	{
		User u = new User(7, "teini", "*******");	
		Assert.assertEquals("7,teini,*******", u.toString());
	}
	
	
}
