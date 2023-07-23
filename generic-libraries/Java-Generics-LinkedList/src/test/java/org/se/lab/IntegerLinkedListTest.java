package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.IntegerLinkedList;


public class IntegerLinkedListTest
{
    private IntegerLinkedList list;
    
    @Before
    public void setup()
    {
        list = new IntegerLinkedList();
        list.add(7).add(3).add(11);        
    }
    
    @Test
    public void testGet()
    {
        Assert.assertEquals(7,list.get(0));
        Assert.assertEquals(3,list.get(1));
        Assert.assertEquals(11,list.get(2));
    }

   @Test(expected=IllegalArgumentException.class)
   public void testGet_WithTooLargeIndex()
   {
       list.get(3);
   }
   
   
   @Test
   public void testToString()
   {
       Assert.assertEquals("{7,3,11}", list.toString());
   }
}
