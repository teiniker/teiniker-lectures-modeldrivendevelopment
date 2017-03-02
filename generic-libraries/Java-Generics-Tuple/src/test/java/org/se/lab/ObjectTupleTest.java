package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.ObjectTuple;


public class ObjectTupleTest
{
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithFirstElementIsNull()
    {
        new ObjectTuple(null, "Teini");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithSecondElementIsNull()
    {
        new ObjectTuple(7, null);
    }

    
    @Test
    public void testGet()
    {
        ObjectTuple t = new ObjectTuple(7, "Teini");
        
        Assert.assertEquals(7, t.getFirstElement());
        Assert.assertEquals("Teini", t.getSecondElement());
    }
    

    @Test
    public void testToString()
    {
        ObjectTuple t = new ObjectTuple(7, "Teini");
        
        Assert.assertEquals("(7,Teini)", t.toString());
    }
    
    
    @Test
    public void testTupleReturnValue()
    {
        ObjectTuple t = doSomething(3, "FHJ");

        Assert.assertEquals(3, t.getFirstElement());
        Assert.assertEquals("FHJ", t.getSecondElement());        
    }
    
    
    /*
     * We can use a Tuple to return two variables in a single 
     * return value.
     */
    protected ObjectTuple doSomething(int i, String s)
    {
        return new ObjectTuple(i,s);
    }
}
