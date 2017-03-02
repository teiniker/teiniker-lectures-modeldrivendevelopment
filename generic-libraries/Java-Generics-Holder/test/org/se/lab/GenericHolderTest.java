package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class GenericHolderTest
{

    @Test
    public void testToString()
    {
        String name = "Teiniker";
        GenericHolder<String> holder = new GenericHolder<String>(name);
        Assert.assertEquals(name, holder.toString());        
    }
    
    
    @Test
    public void testGetValue()
    {
        String name = "Teiniker";
        GenericHolder<String> holder = new GenericHolder<String>(name);
        String value = holder.getValue();
        Assert.assertEquals(name, value);
    }
    
    
    /*
     * Here we create a compile time error by using different types for a
     * GenericHolder<>.
     */
    @Test
    public void testGetValueWithInteger()
    {        
        GenericHolder<Integer> holder = new GenericHolder<Integer>(new Integer(7));                
//        String value = holder.getValue(); // Cannot convert from integer to String
    }

}
