package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test class shows the realization of INOUT parameter passing in Java.
 * We use different approaches to point out the advantages of Java Generics.
 */
public class StringInOutParameterTest
{
    /*
     * Java does not support INOUT behavior of parameters, because object references 
     * are passed by value.
     * A passed parameter value is a copy of the given object reference.
     */
	@Test
	public void testInOutParameter()
    {
        String s = "Message from test client!";
        foo(s);
        System.out.println(">> " + s);
        assertEquals("Message from test client!", s.toString());
    }
    
       
    /*
     * The following methods print the given string (IN parameter) to the console
     * and set the string to a new value (OUT parameter).
     */   
    public void foo(String s)
    {
        System.out.println("foo() IN: " + s);
        String out = "New message from foo()!";
        System.out.println("foo() OUT: " + out);
        s = out;                            // s goes out of scope!!!
    }
}
