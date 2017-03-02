package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

/*
 * A circular buffer, cyclic buffer or ring buffer is a data structure 
 * that uses a single, fixed-size buffer as if it were connected end-to-end.
 */
public class GenericCircularBufferTest
{
    private GenericCircularBuffer<String> buffer = new GenericCircularBuffer<String>(5);
    
    @Test
    public void testPutAndGet()
    {
        buffer.enque("a");
        buffer.enque("b");
        buffer.enque("c");
        buffer.enque("d");
        buffer.enque("e");
        Assert.assertEquals("a", buffer.deque());
        Assert.assertEquals("b", buffer.deque());
        Assert.assertEquals("c", buffer.deque());
        Assert.assertEquals("d", buffer.deque());
        Assert.assertEquals("e", buffer.deque());
    }
    
    
    @Test
    public void testToString()
    {
        buffer.enque("a");
        buffer.enque("b");
        buffer.enque("c");
        buffer.enque("d");
        buffer.enque("e");
        Assert.assertEquals("a b c d e ", buffer.toString());
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsFull()
    {
        buffer.enque("a");
        buffer.enque("b");
        buffer.enque("c");
        buffer.enque("d");
        buffer.enque("e");
        buffer.enque("f");
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsEmpty()
    {
        buffer.deque();
    }
}
