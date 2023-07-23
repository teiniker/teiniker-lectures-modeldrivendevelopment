package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class CharacterQueueTest
{
    private CharacterQueue buffer = new CharacterQueue(5);
    
    @Test
    public void testPutAndGet()
    {
        buffer.enqueue('A');
        buffer.enqueue('B');
        buffer.enqueue('C');
        buffer.enqueue('D');
        buffer.enqueue('E');
        Assert.assertEquals('A', buffer.dequeue());
        Assert.assertEquals('B', buffer.dequeue());
        Assert.assertEquals('C', buffer.dequeue());
        Assert.assertEquals('D', buffer.dequeue());
        Assert.assertEquals('E', buffer.dequeue());
    }
    
    
    @Test
    public void testToString()
    {
        buffer.enqueue('A');
        buffer.enqueue('B');
        buffer.enqueue('C');
        buffer.enqueue('D');
        buffer.enqueue('E');
        Assert.assertEquals("A B C D E ", buffer.toString());
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsFull()
    {
        buffer.enqueue('A');
        buffer.enqueue('B');
        buffer.enqueue('C');
        buffer.enqueue('D');
        buffer.enqueue('E');
        buffer.enqueue('F');
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testIsEmpty()
    {
        buffer.dequeue();
    }
}
