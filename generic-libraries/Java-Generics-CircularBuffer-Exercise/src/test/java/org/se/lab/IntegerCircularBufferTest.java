package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

/*
 * A circular buffer (or cyclic buffer or ring buffer) is a data structure 
 * that uses a single, fixed-size buffer as if it were connected end-to-end.
 * 
 */
public class IntegerCircularBufferTest
{
    private IntegerCircularBuffer buffer = new IntegerCircularBuffer(5);
    
    @Test
    public void testPutAndGet()
    {
        buffer.enque(1);
        buffer.enque(2);
        buffer.enque(3);
        buffer.enque(4);
        buffer.enque(5);
        Assert.assertEquals(1, buffer.deque());
        Assert.assertEquals(2, buffer.deque());
        Assert.assertEquals(3, buffer.deque());
        Assert.assertEquals(4, buffer.deque());
        Assert.assertEquals(5, buffer.deque());
    }
    
    
    @Test
    public void testToString()
    {
        buffer.enque(1);
        buffer.enque(2);
        buffer.enque(3);
        buffer.enque(4);
        buffer.enque(5);
        Assert.assertEquals("1 2 3 4 5 ", buffer.toString());
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsFull()
    {
        buffer.enque(1);
        buffer.enque(2);
        buffer.enque(3);
        buffer.enque(4);
        buffer.enque(5);
        buffer.enque(6);
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsEmpty()
    {
        buffer.deque();
    }
}
