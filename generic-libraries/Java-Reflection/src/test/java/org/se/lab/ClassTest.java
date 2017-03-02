package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class ClassTest
{

	/*
	 * If an instance of an object is available, then the simplest way to get 
	 * its Class is to invoke Object.getClass()
	 */
	@Test
	public void testGetClass()
	{
		User u = new User(7,"teini", "*******");
		
		Class<?> c = u.getClass();
		Assert.assertEquals("org.se.lab.User", c.getName());
	}

	
	/*
	 * If the type is available but there is no instance then it is possible 
	 * to obtain a Class by appending ".class" to the name of the type. 
	 * This is also the easiest way to obtain the Class for a primitive type. 
	 */
	@Test
	public void testClass()
	{
		Class<User> c = User.class;		
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
	
	
	/*
	 * If the fully-qualified name of a class is available, it is possible to 
	 * get the corresponding Class using the static method Class.forName(). 
	 * This cannot be used for primitive types.
	 */
	@Test
	public void testForName() throws ClassNotFoundException
	{
		Class<?> c = Class.forName("org.se.lab.User");
		
		Assert.assertEquals("org.se.lab.User", c.getName());
	}
	
}

