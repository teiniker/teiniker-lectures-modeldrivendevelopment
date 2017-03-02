package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.IntegerHolder;
import org.se.lab.StringHolder;

/**
 * This test class shows the realization of INOUT parameter passing in Java.
 * We use different approaches to point out the advantages of Java Generics.
 */
public class TypedHolderInOutParameterTest
{
    /*
     * We can solve the problem by implementing a type-safe holder object, but we
     * have to implement a holder object for every object type we use as parameter.
     */
	@Test
	public void testStringHolder()
    {
        StringHolder s = new StringHolder("Message from test client!");
        foo(s);
        System.out.println(">> " + s);        
        assertEquals("New message from foo()!", s.toString());
    }
    
	@Test
    public void testIntegerHolder()
    {
        IntegerHolder i = new IntegerHolder(7);
        foo(i);
        System.out.println(">> " + i);        
        assertEquals(13, i.getValue().intValue());
    }
    
    
    /*
     * The following methods print the given string (IN parameter) to the console
     * and set the string to a new value (OUT parameter).
     */
    public void foo(StringHolder holder)
    {
        String in = holder.getValue();           // Compile-time type check!!!
        System.out.println("foo() IN: " + in);
        
        String out = "New message from foo()!";
        System.out.println("foo() OUT: " + out);
        holder.setValue(out);
    }

    
    /*
     * Note the we can overload the foo() methods based on their different 
     * parameter types.
     */
    public void foo(IntegerHolder holder)
    {
        int in = holder.getValue();           // Compile-time type check!!!
        System.out.println("foo() IN: " + in);
        
        int out = 13;
        System.out.println("foo() OUT: " + out);
        holder.setValue(out);
    }    
}
