package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.GenericLinkedList;


public class GenericLinkedListTest
{
    private GenericLinkedList<String> list;
    
    @Before
    public void setup()
    {
        list = new GenericLinkedList<String>();
        list.add("sieben").add("drei").add("elf");        
    }
    
    @Test
    public void testGet()
    {
        Assert.assertEquals("sieben",list.get(0));
        Assert.assertEquals("drei",list.get(1));
        Assert.assertEquals("elf",list.get(2));
    }

   @Test(expected=IllegalArgumentException.class)
   public void testGet_WithTooLargeIndex()
   {
       list.get(3);
   }
   
   
   @Test
   public void testToString()
   {
       Assert.assertEquals("{sieben,drei,elf}", list.toString());
   }
}
