package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.ObjectHolder;

/**
 * This test class shows the realization of INOUT parameter passing in Java.
 * We use different approaches to point out the advantages of Java Generics.
 */
public class ObjectHolderInOutParameterTest
{
    /*
     * We can implement a holder object that uses an Object reference, thus, we can
     * handle every parameter type with a single holder implementation.
     * 
     * Note that we have to cast from the Object type to a particular type every time
     * we retrieve a value from the holder object.
     */
	@Test
	public void testObjectHolderString()
    {
        ObjectHolder s = new ObjectHolder("Message from test client!");
        foo(s);
        System.out.println(">> " + s);        
        assertEquals("New message from foo()!", s.toString());
    }
    
	@Test
    public void testObjectHolderInteger()
    {
		int i = 17;
        ObjectHolder s = new ObjectHolder(i);
        foo2(s);
        System.out.println(">> " + s);        
        assertEquals(13, s.getValue());
    }
    
    
        
    /*
     * The following methods print the given string (IN parameter) to the console
     * and set the string to a new value (OUT parameter).
     */
    
    public void foo(ObjectHolder holder)
    {
        String in = (String)holder.getValue();    // Run-time type check !!!
        System.out.println("foo() IN: " + in);
     
        String out = "New message from foo()!";
        System.out.println("foo() OUT: " + out);
        holder.setValue(out);
    }
    
    
    /*
     * Note that we cannot overload the foo() methods because the have the same
     * parameter types - the ObjectHolder.
     */
    public void foo2(ObjectHolder holder)
    {
    	Object obj = holder.getValue();
    	int in = 0;
    	if(obj instanceof Integer) // Run-time type check !!!
    	{
    		in = (Integer)obj;    
    	}
    	else
    	{
    		throw new IllegalArgumentException("not an Integer value");
    	}
        System.out.println("foo2() IN: " + in);
     
        int out = 13;
        System.out.println("foo2() OUT: " + out);
        holder.setValue(out);
    }
}
