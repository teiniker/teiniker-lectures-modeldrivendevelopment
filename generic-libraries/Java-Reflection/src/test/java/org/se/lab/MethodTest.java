package org.se.lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.User;

public class MethodTest
{
	private Class<User> c;
	private Method[] methods;
	
	@Before
	public void setup()
	{
		c = User.class;
		methods = c.getDeclaredMethods();		
		Assert.assertEquals(7,methods.length);
	}

	
	@Test
	public void testGetId() throws SecurityException, NoSuchMethodException
	{
		System.out.println(Arrays.toString(methods));
		Method m = c.getDeclaredMethod("getId");
		
		Assert.assertEquals(Modifier.PUBLIC, m.getModifiers());
		Assert.assertEquals(int.class, m.getReturnType());		
	}

	
	@Test
	public void testInvokeToString() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		User user = new User(7, "teini", "*****");
		
		Method m = user.getClass().getDeclaredMethod("toString");
		String s = (String)m.invoke(user);
		
		Assert.assertEquals("7,teini,*****", s);
	}
}
