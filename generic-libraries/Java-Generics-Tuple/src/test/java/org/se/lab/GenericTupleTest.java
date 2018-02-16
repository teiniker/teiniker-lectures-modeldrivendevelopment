package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.GenericTuple;


public class GenericTupleTest
{
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithFirstElementIsNull()
    {
        new GenericTuple<Integer,String>(null, "Teini");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructor_WithSecondElementIsNull()
    {
        new GenericTuple<Integer,String>(7, null);
    }

    
    @Test
    public void testGet()
    {
        GenericTuple<Integer,String> t = new GenericTuple<>(7, "Teini");
        
        Assert.assertEquals(Integer.valueOf(7), t.getFirstElement());
        Assert.assertEquals("Teini", t.getSecondElement());
    }
    

    @Test
    public void testToString()
    {
        GenericTuple<Integer,String> t = new GenericTuple<Integer,String>(7, "Teini");
        
        Assert.assertEquals("(7,Teini)", t.toString());
    }
    
    
    @Test
    public void testTupleReturnValue()
    {
        GenericTuple<Integer,String> t = doSomething(3, "FHJ");

        Assert.assertEquals(Integer.valueOf(3), t.getFirstElement());
        Assert.assertEquals("FHJ", t.getSecondElement());        
    }
    
    
    /*
     * We can use a Tuple to return two variables in a single 
     * return value.
     */
    protected GenericTuple<Integer,String> doSomething(int i, String s)
    {
        return new GenericTuple<Integer,String>(i,s);
    }
}
