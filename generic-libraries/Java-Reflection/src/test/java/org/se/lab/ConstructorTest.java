package org.se.lab;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.User;

public class ConstructorTest
{
	private Constructor<?>[] constructors;
	
	@Before
	public void setup()
	{
		Class<User> c = User.class;
		constructors = c.getDeclaredConstructors();		
		Assert.assertEquals(2,constructors.length);
	}
	
	
	@Test
	public void testDefaultConstructor()
	{
		Constructor<?> constr = constructors[1];
		Assert.assertEquals(Modifier.PROTECTED, constr.getModifiers());
		Assert.assertEquals(0, constr.getParameterTypes().length);
	}

	@Test
	public void testInitConstructor()
	{
		Constructor<?> constr = constructors[0];		
		Class<?>[] types = constr.getParameterTypes();
		Assert.assertEquals(3, types.length);
		Assert.assertEquals("int", types[0].getName());
		Assert.assertEquals("java.lang.String", types[1].getName());
		Assert.assertEquals("java.lang.String", types[2].getName());
	}	
}
