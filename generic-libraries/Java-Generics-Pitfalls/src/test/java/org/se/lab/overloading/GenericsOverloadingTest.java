package org.se.lab.overloading;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.overloading.Console;
import org.se.lab.overloading.Holder;


public class GenericsOverloadingTest 
{
	private Console con;
	
	@Before
	public void setUp()
	{
		con = new Console(">> ");
	}
	

	@Test
	public void testInstanceOf()
	{
		Holder<Integer> intHolder = new Holder<Integer>(new Integer(7));
		Holder<String> stringHolder = new Holder<String>("Hallo");
	
		// Generics are implemented by erasure because the types Holder<E> 
		// and Holder<T> are represented at run-time by the same type, Holder.
		Assert.assertTrue(intHolder instanceof Holder);
		Assert.assertTrue(stringHolder instanceof Holder);		
	}

	
	@Test
	public void testPrintInteger()
	{
		con.print(new Holder<Integer>(new Integer(7)));
	}

	@Test
	public void testPrintString()
	{
		con.print2(new Holder<String>("Hallo"));
	}
		
}
