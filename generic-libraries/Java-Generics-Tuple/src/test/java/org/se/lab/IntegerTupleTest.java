package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class IntegerTupleTest
{    
    @Test
    public void testGet()
    {
        IntegerTuple t = new IntegerTuple(7, 13);
        Assert.assertEquals(new Integer(7), t.getFirstElement());
        Assert.assertEquals(new Integer(13), t.getSecondElement());
    }
    
    @Test
    public void testToString()
    {
        IntegerTuple t = new IntegerTuple(7, 13);
        
        Assert.assertEquals("(7,13)", t.toString());
    }
        
    @Test
    public void testTupleReturnValue()
    {
        IntegerTuple t = doSomething(3, 7);

        Assert.assertEquals(new Integer(3), t.getFirstElement());
        Assert.assertEquals(new Integer(7), t.getSecondElement());        
    }
    
 
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithFirstElementIsNull()
    {
        new IntegerTuple(null, 7);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithSecondElementIsNull()
    {
        new IntegerTuple(7, null);
    }

    
    
    protected IntegerTuple doSomething(Integer a, Integer b)
    {
        return new IntegerTuple(a,b);
    }
}
