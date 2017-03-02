package org.se.lab.instantiation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.se.lab.inheritance.User;
import org.se.lab.instantiation.GenericFactory;


public class GenericFactoryTest
{
	@Test
	public void testCreateElement()
	{
		User u = GenericFactory.createElement(User.class);		
		assertNotNull(u);
		assertTrue(u instanceof User);
	}
	
	
	@Test
	public void testCreateList()
	{
		List<String> list = GenericFactory.createList("Cat", 3);
		assertEquals(3,list.size());
		assertEquals("Cat", list.get(0));
		assertEquals("Cat", list.get(1));
		assertEquals("Cat", list.get(2));
	}
	
	
	@Test
	public void testCreateArray()
	{
		String[] array = GenericFactory.createArray(String.class, "Cat", 3);
		assertEquals(3,array.length);
		assertEquals("Cat", array[0]);
		assertEquals("Cat", array[1]);
		assertEquals("Cat", array[2]);		
	}
	
}
