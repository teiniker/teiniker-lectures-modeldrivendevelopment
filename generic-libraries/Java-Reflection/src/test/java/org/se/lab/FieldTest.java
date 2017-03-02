package org.se.lab;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.User;

public class FieldTest
{
	private Class<User> c;
	private Field[] fields;
	
	@Before
	public void setup()
	{
		c = User.class;
		fields = c.getDeclaredFields();		
		Assert.assertEquals(3,fields.length);
	}

	
	@Test
	public void testId() throws SecurityException, NoSuchFieldException
	{
		Field id = c.getDeclaredField("id");
		
		Class<?> fieldType = id.getType();
		Assert.assertEquals("int", fieldType.getName());		
	}
	
	@Test
	public void testIdSetterAndGetter() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		User user = new User(7, "teini", "*****");
		
		Field id = user.getClass().getDeclaredField("id");
		id.setInt(user, 17);
		Assert.assertEquals(17, user.getId());

		int i = id.getInt(user);
		Assert.assertEquals(17, i);
	}
}
