package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GenericStackTest
{
    private GenericStack<String> s;
    
    @Before
    public void setup()
    {
        s = new GenericStack<String>(5);
    }
    
    @Test
    public void testIsEmpty()
    {
        Assert.assertTrue(s.isEmpty());
        
        s.push("one");
        Assert.assertFalse(s.isEmpty());
    }

    @Test
    public void testPushPop()
    {
        s.push("aaa");
        s.push("bbb");
        s.push("ccc");
        
        Assert.assertEquals("ccc", s.pop());
        Assert.assertEquals("bbb", s.pop());
        Assert.assertEquals("aaa", s.pop());
        Assert.assertTrue(s.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmptyStack()
    {
        s.pop();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPushFullStack()
    {
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6"); //!!!       
    }
    
    
    @Test
    public void testIntegerStack()
    {
        GenericStack<Integer> i = new GenericStack<Integer>(3);
        
        Assert.assertTrue(i.isEmpty());
        i.push(1);
        i.push(2);
        i.push(3);
        Assert.assertFalse(i.isEmpty());
        Assert.assertEquals(Integer.valueOf(3), i.pop());
        Assert.assertEquals(Integer.valueOf(2), i.pop());
        Assert.assertEquals(Integer.valueOf(1), i.pop());
        Assert.assertTrue(i.isEmpty());        
    }
}
