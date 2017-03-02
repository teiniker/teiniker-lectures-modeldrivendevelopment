package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class StringHolderTest
{

    @Test
    public void testToString()
    {
        String name = "Teiniker";
        StringHolder holder = new StringHolder(name);
        Assert.assertEquals(name, holder.toString());        
    }
    
    
    @Test
    public void testGetValue()
    {
        String name = "Teiniker";
        StringHolder holder = new StringHolder(name);
        String value = holder.getValue();
        Assert.assertEquals(name, value);
    }
    
    
    /*
     * Here we create a compile time error by using a wrong type for a
     * StringHolder.
     */
    @Test
    public void testGetValueWithInteger()
    {        
        StringHolder holder = new StringHolder("hello");                
//        Integer value = holder.getValue(); // Cannot convert from String to Integer
    }

}
