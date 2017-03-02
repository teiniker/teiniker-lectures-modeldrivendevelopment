package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class ObjectHolderTest
{    
    @Test
    public void testToString()
    {
        String name = "Teiniker";
        ObjectHolder holder = new ObjectHolder(name);        
        Assert.assertEquals(name, holder.toString());        
    }
    
    @Test
    public void testGetValue()
    {
        String name = "Teiniker";
        ObjectHolder holder = new ObjectHolder(name);        
        String value = (String)holder.getValue();        
        Assert.assertEquals(name, value);        
    }
    
    
    /*
     * If we use wrong types we will run into a runtime exception!
     */
    @Test(expected=ClassCastException.class)
    public void testGetValueWithInteger()
    {       
        ObjectHolder holder = new ObjectHolder(new Integer(7));                
        String value = (String)holder.getValue(); //!!!
    }
}
