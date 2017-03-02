package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.GenericHolder;

/**
 * This test class shows the realization of INOUT parameter passing in Java.
 * We use different approaches to point out the advantages of Java Generics.
 */
public class GenericHolderInOutParameterTest
{
    /*
     * Using Java Generics, we can handle all parameter types with a single holder
     * implementation while archiving compile-time type safety, thus, there is no
     * need for explicit type casting.
     */
    @Test
    public void testGenericHolderString()
    {
        GenericHolder<String> s = 
        	new GenericHolder<String>("Message from test client!");
        foo(s);
        System.out.println(">> " + s);
        assertEquals("New message from foo()!", s.toString());
    }
    
    @Test
    public void testGenericHolderInteger()
    {
        GenericHolder<Integer> i = new GenericHolder<Integer>(7);
        foo2(i);
        System.out.println(">> " + i);        
        assertEquals(13,i.getValue().intValue());
    }

    
    /*
     * The following methods print the given string (IN parameter) to the console
     * and set the string to a new value (OUT parameter).
     */
    
    public void foo(GenericHolder<String> holder)
    {
    	String in = holder.getValue();           // Compile-time type check!!!
        System.out.println("foo() IN: " + in);
        
        String out = "New message from foo()!";
        System.out.println("foo() OUT: " + out);
        holder.setValue(out);
    }
    
    
    /*
     * Note that we cannot overload the foo() methods because the have
     * the same parameter type - the same generic class GenericHolder<E>.
     */
    public void foo2(GenericHolder<Integer> holder)
    {
        int in = holder.getValue();           // Compile-time type check!!!
        System.out.println("foo2() IN: " + in);
        
        int out = 13;
        System.out.println("foo2() OUT: " + out);
        holder.setValue(out);
    }
}
