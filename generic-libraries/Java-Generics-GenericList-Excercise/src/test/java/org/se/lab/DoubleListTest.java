package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.DoubleList;


public class DoubleListTest
{
    private DoubleList list;
    
    @Before
    public void setup()
    {
        list = new DoubleList();
        list.add(7.0).add(3.0).add(11.0);        
    }
    
    
    @Test
    public void testSum()
    {
    	double sum = list.sum();
    	
    	Assert.assertEquals(7.0+3.0+11.0, sum, 10E-6);
    }
    
    @Test
    public void testGet()
    {
        Assert.assertEquals(7.0,list.get(0), 10E-6);
        Assert.assertEquals(3.0,list.get(1), 10E-6);
        Assert.assertEquals(11.0,list.get(2), 10E-6);
    }

   @Test(expected=IllegalArgumentException.class)
   public void testGet_WithTooLargeIndex()
   {
       list.get(3);
   }
}
