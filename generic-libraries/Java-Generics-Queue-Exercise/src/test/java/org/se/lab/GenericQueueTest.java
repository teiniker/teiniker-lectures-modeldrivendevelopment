package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class GenericQueueTest
{
    private GenericQueue<String> buffer = new GenericQueueImpl<String>(5);
    
    @Test
    public void testPutAndGet()
    {
        buffer.enqueue("a");
        buffer.enqueue("b");
        buffer.enqueue("c");
        buffer.enqueue("d");
        buffer.enqueue("e");
        Assert.assertEquals("a", buffer.dequeue());
        Assert.assertEquals("b", buffer.dequeue());
        Assert.assertEquals("c", buffer.dequeue());
        Assert.assertEquals("d", buffer.dequeue());
        Assert.assertEquals("e", buffer.dequeue());
    }
    
    
    @Test
    public void testToString()
    {
        buffer.enqueue("a");
        buffer.enqueue("b");
        buffer.enqueue("c");
        buffer.enqueue("d");
        buffer.enqueue("e");
        Assert.assertEquals("a b c d e ", buffer.toString());
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsFull()
    {
        buffer.enqueue("a");
        buffer.enqueue("b");
        buffer.enqueue("c");
        buffer.enqueue("d");
        buffer.enqueue("e");
        buffer.enqueue("f");
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsEmpty()
    {
        buffer.dequeue();
    }
}
